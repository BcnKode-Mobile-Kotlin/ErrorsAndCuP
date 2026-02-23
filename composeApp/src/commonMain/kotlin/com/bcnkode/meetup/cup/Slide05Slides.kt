package com.bcnkode.meetup.cup

import com.bcnkode.meetup.SlideScaffold
import net.kodein.cup.PreparedSlide
import net.kodein.cup.SlideSpecs
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val cupSlides by PreparedSlide(
    stepCount = 3,
    specs = SlideSpecs(),
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    )
) {
    slideContent { step ->
        SlideScaffold(
            title = "Slides",
            subtitle = "Creación de una slide",
        ) {
            val slideSourceCode = rememberSourceCode(language = "kotlin") {
                val params by marker(hidden(0))
                val themeOverride by marker(onlyShown(2))
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
                    ${themeOverride}    MySecondTheme {
                            SlideContent()
                        }${X}
                    }
                """.trimIndent()
            }
            SourceCode(
                sourceCode = slideSourceCode,
                step = step,
                theme = SourceCodeThemes.darcula,
            )
        }
    }
}