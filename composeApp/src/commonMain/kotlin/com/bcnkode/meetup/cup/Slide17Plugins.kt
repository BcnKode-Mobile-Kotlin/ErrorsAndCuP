package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.composables.CodeInPane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.widgets.material3.BulletPoints

val pluginsCuP by Slide {
    val code = rememberSourceCode(language = "kotlin") {
        """
            fun main() = cupApplication {
                Presentation(
                    configuration = {
                        laser()
                        speakerWindow()
                    }
                )
            }
        """.trimIndent()
    }
    val speakerNoteCode = rememberSourceCode(language = "kotlin") {
        """
            val slide by Slide(
                user = SpeakerNote("My private note")
            ) {
                ...
            »
        """.trimIndent()
    }
    TitleAndContentScaffold(
        title = "Plugins",
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            BulletPoints {
                BulletPoint {
                    Text("Laser")
                }
                BulletPoint {
                    Text("Speaker window")
                }
            }
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CodeInPane(code)
                Spacer(Modifier.width(8.dp))
                CodeInPane(speakerNoteCode)
            }
            Spacer(Modifier.weight(1f))
        }
    }
}