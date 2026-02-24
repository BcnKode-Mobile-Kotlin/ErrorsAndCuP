package com.bcnkode.meetup.cup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.MyStyleSheet.code
import com.bcnkode.meetup.composables.Code
import com.bcnkode.meetup.composables.CodeInPane
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val sourceCodeCuP by Slide(
    stepCount = 2,
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    )
) { step ->
    val sourceCode = rememberSourceCode(language = "kotlin") {
        """
            val codeSlide by Slide {
                val sourceCode = rememberSourceCode(language = "kotlin") {
                    ${"\"\"\""}
                    fun main() {
                        println("Hello World!")
                    }
                    ${"\"\"\""}.trimIndent()
                }
                SourceCode(
                    code = sourceCode,
                    style = TextStyle(fontSize = 8.sp),
                    theme = SourceCodeThemes.darcula,
                )
            }
        """.trimIndent()
    }
    val outputCode = rememberSourceCode(language = "kotlin") {
        """
            fun main() {
                println("Hello World!")
            }
        """.trimIndent()
    }

    TitleAndContentScaffold(
        title = "Source code",
        subtitle = "Write code in CuP"
    ) {
        Column {
            if (step == 0) {
                CodeInPaneWithTitle(
                    title = "This is the way to write code in CuP",
                    code = sourceCode
                )
                Spacer(Modifier.height(20.dp))
            }
            if (step >= 1) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "The output is this:", style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(8.dp))
                    Code(outputCode)
                }
            }
        }
    }
}