package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

val raiseContextParametersErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
    stepCount = 3,
) { step ->

    val contextParameters = rememberSourceCode(language = "kotlin") {
            """
interface Logger {
    internal fun log(level: LogLevel, group: String?, message: String)
}
context(logger: Logger) 
fun log(level: LogLevel, group: String?, message: String) =
    logger.log(level, group, message)
  
  
context(_: Raise<Error>) 
fun validatePerson(name: String, age: Int): Person
""".trimIndent()
        }

    val raiseWithContextsCode = rememberSourceCode(language = "kotlin") {
        """
context(_: Raise<ValidationError>, _: Raise<ApiError>)
fun registerUser(email: String, pass: Int) {
    ensure(pass.length >= 8) { TooShortPassword }
    ensure(email.contains("@")) { InvalidEmail }
    return api.createUser(email, pass)
}

context(_: Raise<ApiError>)
fun Api.createUser(email: String, pass: Int): User = ...
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
        title = "A bright future",
        subtitle = "Context Parameters improve Raise",
        contentAlignment = Alignment.Center,
    ) {
        when (step) {
            0 -> CodeInPaneWithTitle("What about multiple errors?", raiseUtilsCode)
            1 -> CodeInPaneWithTitle("New Kotlin feature: Context Parameters (experimental)", contextParameters)
            2 -> CodeInPaneWithTitle("We can declare multiple error types!", raiseWithContextsCode)
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
