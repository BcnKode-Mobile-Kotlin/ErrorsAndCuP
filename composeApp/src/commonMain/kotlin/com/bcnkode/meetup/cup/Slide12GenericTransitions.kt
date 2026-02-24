package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val genericTransitionsCuP by Slide(
    stepCount = 2,
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    )
) { step ->
    val sourceCode = rememberSourceCode(language = "kotlin") {
        val highlight by marker(highlighted(1))
        """
        fun main() = cupApplication {
            Presentation(
                slides = Slides(slides),
                configuration = {
        ${highlight}            defaultSlideSpecs = SlideSpecs(
                        size = SLIDE_SIZE_16_9,
                        startTransitions = TransitionSet.fade,
                        endTransitions = TransitionSet.fade,
                    )${X}
                }
            ) { slidesContent ->
                slidesContent()
            }
        }
    """.trimIndent()
    }

    TitleAndContentScaffold(
        title = "Transitions",
        subtitle = "Generic"
    ) {
        Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(3f))
            CodeInPaneWithTitle(
                title = "Set a generic transitions in the whole presentation",
                code = sourceCode,
                modifier = Modifier.fillMaxWidth(),
                step = step,
            )
            Spacer(Modifier.weight(3f))
        }
    }
}