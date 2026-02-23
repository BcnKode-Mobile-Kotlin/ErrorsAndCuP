package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.SlideScaffold
import com.bcnkode.meetup.layouts.Pane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.PreparedSlide
import net.kodein.cup.PreparedSlideScope.slideContent
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val application by Slide(
    stepCount = 3,
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
) { step ->
    val sourceCode = rememberSourceCode(language = "Kotlin") {
        val theme by marker(onlyShown(1..2)) // Apareix al pas 2
        val indent by marker(onlyShown(1..2)) // Els espais extra també apareixen al pas 2
        val bold by marker(highlighted(2))
        val i = "${indent}    ${X}"

        """
            fun main() = cupApplication(title = "My presentation") {
            ${theme}    ${bold}MyTheme {${X}${X}
            $i    Presentation(
            $i        slides = Slides(slide1, slide2),
            $i        configuration = {},
            $i        backgroundColor = MaterialTheme.colorScheme.background,
            $i    ) { slidesContent ->
            $i        slidesContent()
            $i    }
            ${theme}    ${bold}}${X}${X}
            }
        """.trimIndent()
    }
    TitleAndContentScaffold(
        title = "CuP application",
        contentAlignment = Alignment.Center,
    ) {
        Column(Modifier.fillMaxHeight()) {
            Spacer(Modifier.weight(3f))
            Text("commonMain/my/package/Main.kt")
            Spacer(Modifier.height(8.dp))
            Pane(Modifier.align(Alignment.CenterHorizontally)) {
                SourceCode(
                    sourceCode = sourceCode,
                    step = step,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 8.sp),
                    theme = SourceCodeThemes.darcula,
                )
            }
            Spacer(Modifier.weight(3f))
        }
    }
}