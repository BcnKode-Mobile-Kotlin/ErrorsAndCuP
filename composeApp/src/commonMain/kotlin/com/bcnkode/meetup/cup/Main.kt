package com.bcnkode.meetup.cup

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.remember
import net.kodein.cup.Presentation
import net.kodein.cup.Slides
import net.kodein.cup.cupApplication
import net.kodein.cup.laser.laser
import net.kodein.cup.speaker.speakerWindow
import net.kodein.cup.widgets.material3.cupScaleDown
import org.kodein.emoji.compose.EmojiService

fun main() = cupApplication(title = "Compose ur Pres - Tu presentación también compila") {
    remember {
        EmojiService.initialize()
    }
    MaterialTheme(
        colorScheme = darkColorScheme(),
        typography = MaterialTheme.typography.cupScaleDown(),
    ) {
        Presentation(
            slides = Slides(emptyList()),
            configuration = {
                laser()
                speakerWindow()
            }
        ) { slidesContent ->
            slidesContent()
        }
    }
}
