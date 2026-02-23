package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.layouts.Pane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.SlideSpecs
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val slidesCuP by Slide(
    stepCount = 4,
    specs = SlideSpecs(),
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    )
) { step ->
    val slideSourceCode = rememberSourceCode(language = "kotlin") {
        val params by marker(hidden(0))
        val content by marker(hidden(0, 1))
        val themeOverride by marker(onlyShown(3))
        val indent by marker(onlyShown(3))
        """
            val slide1 by Slide(
            ${params}    stepCount = 3,
                specs = SlideSpecs(
                    size = DpSize.Unspecified,
                    startTransitions = TransitionSet.Unspecified,
                    endTransitions = TransitionSet.Unspecified
                )
                user = SpeakerNotes("This is a note"),${X}
            ) {
            ${themeOverride}    MySecondTheme {${X}
            ${indent}    ${X}   ${content}SlideContent()${X}
            ${themeOverride}    }${X}
            }
        """.trimIndent()
    }
    TitleAndContentScaffold(
        title = "Slides",
        subtitle = "Build a slide",
        contentAlignment = Alignment.Center,
    ) {
        Column(Modifier.fillMaxHeight()) {
            Spacer(Modifier.weight(3f))
            Pane(Modifier.align(Alignment.CenterHorizontally)) {
                SourceCode(
                    sourceCode = slideSourceCode,
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