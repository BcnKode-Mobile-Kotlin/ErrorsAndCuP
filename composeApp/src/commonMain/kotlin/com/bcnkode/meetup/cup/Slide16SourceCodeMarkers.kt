package com.bcnkode.meetup.cup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.composables.Code
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode

val sourceCodeMarkersCuP by Slide(
    stepCount = 5,
) { step ->
    TitleAndContentScaffold(
        title = "Source code",
        subtitle = "Animate code"
    ) {
        val sourceCode = rememberSourceCode(language = "kotlin") {
            """
            val sourceCode = rememberSourceCode(language = "kotlin") {
                val hello by marker(onlyShow(0, 2))
                val hey by marker(hidden(1))
                val goodbye by marker(highlighted(2))
                ${"\"\"\""}
                fun main() {
                    ${"\${hello}"}println("Hello World!")${"\${X}"}
                    ${"\${hey}"}println("Hey World!")${"\${X}"}
                    ${"\${goodbye}"}println("Goodbye World!")${"\${X}"}
                }
                ${"\"\"\""}.trimIndent()
            }
        """.trimIndent()
        }
        val outputCode = rememberSourceCode(language = "kotlin") {
            val hello by marker(onlyShown(1, 3, 4))
            val hey by marker(hidden(3))
            val goodbye by marker(highlighted(4))
            """
                fun main() {
                    ${hello}println("Hello World!")${X}
                    ${hey}println("Hey World!")${X}
                    ${goodbye}println("Goodbye World!")${X}
                }
            """.trimIndent()
        }
        Column {
            if (step == 0) {
                CodeInPaneWithTitle(
                    title = "This is the way to write code in CuP",
                    code = sourceCode
                )
                Spacer(Modifier.height(20.dp))
            }
            AnimatedVisibility(step >= 1) {
                Column {
                    Text(text = "The output is this:", style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(8.dp))
                    Code(outputCode, step = step)
                }
            }
        }
    }
}