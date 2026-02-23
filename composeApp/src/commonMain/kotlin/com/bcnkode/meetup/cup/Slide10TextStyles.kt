package com.bcnkode.meetup.cup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.composables.CodeInPane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled

val styleCuP by Slide(
    stepCount = 5,
    user = SpeakerNotes(
        """
        
        """.trimIndent()
    )
) { step ->
    val jetpackComposeStyleCode = rememberSourceCode(language = "kotlin") {
        """
            Text(
                text = buildAnnotatedString {
                    append("\"Hello, ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("my friend")
                    }
                    append("\"")
                }
            )
        """.trimIndent()
    }
    val cupStyleCode = rememberSourceCode(language = "kotlin") {
        """
            Text(text = styled { "\"Hello, ${'$'}{+b}my friend${'$'}{-b}\"" })
        """.trimIndent()
    }

    TitleAndContentScaffold(
        title = "Styled text",
        subtitle = "Jetpack compose form vs CuP form"
    ) {
        Column {
            AnimatedVisibility(step >= 1) {
                Text(
                    styled { "\"Hello, ${+b}my friend${-b}\"" },
                )
            }
            Spacer(Modifier.height(16.dp))
            AnimatedVisibility(step >= 2) {
                Column {
                    Text(text = "Jetpack compose style:")
                    Spacer(Modifier.height(8.dp))
                    CodeInPane(code = jetpackComposeStyleCode)
                }
            }
            Spacer(Modifier.height(16.dp))
            AnimatedVisibility(step >= 3) {
                Column {
                    Text(text = "CuP style:")
                    Spacer(Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        CodeInPane(code = cupStyleCode)
                        Spacer(Modifier.width(16.dp))

                        AnimatedVisibility(
                            visible = step >= 4,
                            enter = fadeIn(),
                            exit = fadeOut(),
                        ) {
                            Column {
                                Text(text = styled { "b = ${+b}bold${-b}" })
                                Text(text = styled { "i = ${+i}italic${-i}" })
                            }
                        }
                    }
                }
            }
        }
    }
}
