package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.layouts.TwoPanes
import com.bcnkode.meetup.composables.Code
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints

val kotlinResultErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
    stepCount = 3,
) { step ->
    val resultCode = rememberSourceCode(language = "kotlin") {
        val failure by marker(highlighted(1))
        """
class Result<out T>(val value: Any?) {
    companion object {
        public inline fun <T> success(
            value: T,
        ): Result<T> = Result(value)
        public inline fun <T> failure(
            exception: Throwable,
        ): Result<T> = Result(Failure(exception))
    }
${failure}    class Failure(
        val exception: Throwable
    )${X}
}
""".trimIndent()
    }

    TitleAndContentScaffold(
        title = "Present: modeling results",
        subtitle = "Kotlin Result type",
    ) {
        TwoPanes(
            leftContent = {
                Column {
                    Text("Error must be a throwable:")
                    Spacer(Modifier.height(16.dp))
                    BulletPoints {
                        BulletPoint {
                            Text("We cannot express errors as easily:\n - Limited types\n - Message as description")
                        }
                        BulletPoint {
                            Text("Performance penalty")
                        }
                    }
                }
            },
            rightContent = {
                Box(
                    Modifier.padding(8.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Code(
                        resultCode,
                        modifier = Modifier,
                        step = step,
                    )
                }
            },
            rightFillsHeight = false,
        )
    }
}
