package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.Sizes
import com.bcnkode.meetup.errorhandling.MyResultNested
import com.bcnkode.meetup.layouts.Pane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.eh_railways_1
import meetup_cup.composeapp.generated.resources.eh_railways_2
import meetup_cup.composeapp.generated.resources.eh_railways_3
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
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
    stepCount = 2,
) { step ->

    val myResultCode = rememberSourceCode(language = "kotlin") {
            """
userRepository.findById(userId)
    .mapError { it.toUi() }
    .andThen { user ->
        productRepository.findById(productId)
            .mapError { it.toUi() }
            .andThen { product ->
                priceCalculator.calculate(user, product)
                    .mapError { it.toUi() }
            }
        }
""".trimIndent()
        }

    val raiseCode = rememberSourceCode(language = "kotlin") {
        """
myResult {
    val user = userRepository.findById(userId)
        .mapError { it.toUi() }.bind()
    val product = productRepository.findById(productId)
        .mapError { it.toUi() }.bind()
    priceCalculator.calculate(user, product)
        .mapError { it.toUi() }.bind()
}
""".trimIndent()
    }

    TitleAndContentScaffold(
        title = "Working with result types",
        subtitle = "Railway oriented programming - nesting",
        contentAlignment = Alignment.Center,
    ) {
        when (step) {
            0 -> MyResultNested(myResultCode)
            1 -> RaiseSimpler(raiseCode)
        }
    }
}

@Composable
private fun MyResultNested(myResultCode: SourceCode) {
    Column {
        Text("Nested calls with MyResult", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(8.dp))
        Pane {
            SourceCode(
                myResultCode,
                modifier = Modifier.padding(16.dp),
                style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 8.sp),
                theme = SourceCodeThemes.darcula,
            )
        }
    }
}
@Composable
private fun RaiseSimpler(raiseCode: SourceCode) {
    Column {
        Text("Flattened nested calls with Raise", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(8.dp))
        Pane {
            SourceCode(
                raiseCode,
                modifier = Modifier.padding(16.dp),
                style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 8.sp),
                theme = SourceCodeThemes.darcula,
            )
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