package com.bcnkode.meetup.cup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.composables.CodeInPane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.SpanStyleSheet
import net.kodein.cup.ui.styled

val customStyleCuP by Slide(
    stepCount = 6,
    user = SpeakerNotes(
        """
        
        """.trimIndent()
    )
) { step ->
    val customStyleCode = rememberSourceCode(language = "kotlin") {
        """
            object MyStyleSheet : SpanStyleSheet() {
                val red by registerMarker(
                    SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        textDecoration = TextDecoration.Underline,
                    )
                )
            }
        """.trimIndent()
    }
    val textStyleCode = rememberSourceCode(language = "kotlin") {
        val highlight by marker(highlighted(4))
        """
            Text(
                ${highlight}styled(MyStyleSheet) {${X} "\"This is a ${highlight}${'$'}{+red}${X}red underlined text${highlight}${'$'}{-red}${X}\"" },
            )
        """.trimIndent()
    }

    TitleAndContentScaffold(
        title = "Styled text",
        subtitle = "Custom style"
    ) {
        Column {
            AnimatedVisibility(step >= 1) {
                Text(
                    styled(CustomSpanStyle) { "\"This is a ${+redUnderline}red underlined text${-redUnderline}\"" },
                )
            }
            Spacer(Modifier.height(16.dp))
            AnimatedVisibility(step >= 2) {
                Column {
                    CodeInPane(code = customStyleCode)
                    Spacer(Modifier.height(16.dp))
                    AnimatedVisibility(step >= 3) {
                        CodeInPane(code = textStyleCode, step = step)
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}

private object CustomSpanStyle : SpanStyleSheet() {
    val redUnderline by registerMarker(
        SpanStyle(
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            textDecoration = TextDecoration.Underline,
        )
    )
}
