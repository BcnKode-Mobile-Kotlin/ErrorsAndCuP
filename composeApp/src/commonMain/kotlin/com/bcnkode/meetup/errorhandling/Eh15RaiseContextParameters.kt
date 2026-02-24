package com.bcnkode.meetup.errorhandling

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.Sizes
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.SAStyle
import net.kodein.cup.sa.line
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

val raiseContextParametersErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
    stepCount = 8,
) { step ->

    val contextParameters = rememberSourceCode(language = "kotlin") {
        val log by marker(onlyShown(3..4))
        val raise by marker(onlyShown(4))
            """
interface Logger {
    internal fun log(level: LogLevel, group: String?, message: String)
}
${log}context(logger: Logger) 
fun log(level: LogLevel, group: String?, message: String) =
    logger.log(level, group, message)${X}
  
  
${raise}context(_: Raise<Error>) 
fun validatePerson(name: String, age: Int): Person${X}
""".trimIndent()
        }

    val raiseWithContextsCode = rememberSourceCode(language = "kotlin") {
        val highlight by marker(highlighted(6))
        """
context(_: Raise<${highlight}ValidationError${X}>, _: Raise<${highlight}ApiError${X}>)
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
        val errorStyle = SAStyle.line(Color.Red, squiggle = true, through = false)
        val error by marker(styled(errorStyle, 1))
        """
fun ${error}Raise<OrderError>.Raise<OrderError>${X}.myMethod() {...}
""".trimIndent()
    }

    TitleAndContentScaffold(
        title = "A bright future",
        subtitle = "Context Parameters improve Raise",
        contentAlignment = Alignment.Center,
    ) {
        Column {
            when (step) {
                0,1 -> CodeInPaneWithTitle("What about multiple errors?", raiseUtilsCode, step = step)
                2,3,4 -> CodeInPaneWithTitle("New Kotlin feature: Context Parameters (experimental)", contextParameters, step = step)
                5,6,7 -> CodeInPaneWithTitle("We can declare multiple error types!", raiseWithContextsCode, step = step)
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
