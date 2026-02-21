package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.SlideScaffold
import net.kodein.cup.PreparedSlide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val application by PreparedSlide(
    stepCount = 3,
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
) {
    val sourceCode = rememberSourceCode(language = "Kotlin") {
        val presentation by marker(onlyShown(1))
        val theme by marker(onlyShown(2))
        """
            fun main() = cupApplication(title = "My presentation") {
            ${presentation}    Presentation(
                    slides = Slides(slide1, slide2),
                    configuration = {},
                    backgroundColor = MaterialTheme.colorScheme.background,
                ) { slidesContent ->
                    slidesContent()
                }${X}
            ${theme}    MyTheme {
                    Presentation(
                        slides = Slides(slide1, slide2),
                        configuration = {},
                        backgroundColor = MaterialTheme.colorScheme.background,
                    ) { slidesContent ->
                        slidesContent()
                    }
                }${X}
            }
        """.trimIndent()
    }
    slideContent { step ->
        SlideScaffold(
            title = "Iniciar presentación"
        ) {
            Column {
                Text(
                    text = "commonMain/my/package/Main.kt",
                    modifier = Modifier.padding(bottom = 16.dp),
                )
                SourceCode(
                    sourceCode = sourceCode,
                    step = step,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = FontFamily.Monospace,
                        fontSize = 10.sp,
                    ),
                    theme = SourceCodeThemes.darcula,
                )
            }
        }
    }
}