package com.bcnkode.meetup.errorhandling

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.Sizes
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

val needForRaiseErrorHandling by Slide(
    user = SpeakerNotes(
        """
            para las excepciones, no podemos hacer un when, hay que listar todas las que pueden ocurrir
            Con MyResult, tenemos un tipo que podemos pasar a un método para que se gestione
        """.trimIndent()
    ),
    stepCount = 3,
) { step ->

    val myResultCode = rememberSourceCode(language = "kotlin") {
            """
userRepository.findById(userId)
    .andThen { user ->
        productRepository.findById(productId)
            .andThen { product ->
                priceCalculator.calculate(user, product)
            }
        }.mapError { it.toUi() }
""".trimIndent()
        }

    val raiseCode = rememberSourceCode(language = "kotlin") {
        """
myResult {
    val user = userRepository.findById(userId).bind()
    val product = productRepository.findById(productId).bind()
    priceCalculator.calculate(user, product).bind()
}.mapError { it.toUi() }
""".trimIndent()
    }

    val raiseUtilsCode = rememberSourceCode(language = "kotlin") {
        """
fun Raise<OrderError>.findById(userId: Int): User =
    ensureNotNull(db.findById(userId)) { UserNotFound(userId) }
    
fun Raise<OrderError>.processPayment(order: Order) {
    ensure(Buy in order.user.permissions) { NotBuyPermission }
    if (order.price > balance) raise(OrderError.InsufficientFunds)
    // calculate
}
""".trimIndent()
    }

    TitleAndContentScaffold(
        title = "Working with result types",
        subtitle = "Railway oriented programming - nesting",
        contentAlignment = Alignment.Center,
    ) {
        when (step) {
            0, 1 -> RaiseUnnesting(myResultCode, raiseCode, showRaise = step == 1)
            2 -> Column {
                CodeInPaneWithTitle("Raise in internal functions", raiseUtilsCode)
            }
        }
    }
}

@Composable
private fun RaiseUnnesting(myResultCode: SourceCode, raiseCode: SourceCode, showRaise: Boolean) {
    Column(Modifier.animateContentSize(animationSpec = spring(stiffness = Spring.StiffnessMedium))) {
        CodeInPaneWithTitle("Nested calls with MyResult", myResultCode)
        AnimatedVisibility(showRaise) {
            Column {
                Spacer(Modifier.height(16.dp))
                CodeInPaneWithTitle("Flattened nested calls with Raise", raiseCode)
            }
        }
    }
}

@Composable
private fun ColumnScope.Image(res: DrawableResource) {
    Image(
        painter = painterResource(res),
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
        modifier = Modifier.clip(RoundedCornerShape(Sizes.roundedCorners))
            .align(Alignment.CenterHorizontally).height(92.dp),
    )
}

@Composable
private fun ContentOfSingleImage(res: DrawableResource) {
    Column(Modifier.fillMaxSize()) {
        Spacer(Modifier.weight(1f))
        Image(res)
        Spacer(Modifier.weight(1f))
    }
}