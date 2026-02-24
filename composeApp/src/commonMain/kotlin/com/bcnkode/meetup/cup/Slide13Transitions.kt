package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.bcnkode.meetup.composables.CodeInPane
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val transitionsCuP by Slide(
    stepCount = 2,
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    )
) { step ->
    val sourceCode = rememberSourceCode(language = "kotlin") {
        """
        val slide by Slide(
            specs = SlideSpecs(
                startTransitions = TransitionSet.moveVertical,
                endTransitions = TransitionSet.moveVertical,
            )
        ) {
            ...
        }
    """.trimIndent()
    }
    val transitionSetCode = rememberSourceCode(language = "kotlin") {
        """
            TransitionSet(
                enter = { fadeIn() + slideIn() },
                exit = { fadeOut() + slideOut() }, 
            )
        """.trimIndent()
    }

    TitleAndContentScaffold(
        title = "Transitions",
        subtitle = "Specific"
    ) {
        Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(3f))
            if (step == 0) {
                CodeInPaneWithTitle(
                    title = "Set a specific transitions",
                    code = sourceCode,
                    modifier = Modifier.fillMaxWidth(),
                )
            } else {
                CodeInPane(
                    code = transitionSetCode,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Spacer(Modifier.weight(3f))
        }
    }
}