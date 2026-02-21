package com.bcnkode.meetup

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.bcnkode.meetup.cup.configuration
import com.bcnkode.meetup.cup.introCuP
import com.bcnkode.meetup.cup.whatAndWhy
import net.kodein.cup.Presentation
import net.kodein.cup.Slides
import net.kodein.cup.cupApplication
import net.kodein.cup.laser.laser
import net.kodein.cup.speaker.speakerWindow
import org.kodein.emoji.compose.EmojiService

fun main() = cupApplication(title = "Gestión de errors y slides en Kotlin") {
    remember {
        EmojiService.initialize()
    }
    BcnKodeTheme {
        SlidesPresentation()
    }
}

@Composable
fun SlidesPresentation() {
    Presentation(
        slides = slides,
        configuration = {
            laser()
            speakerWindow()
        },
        backgroundColor = MaterialTheme.colorScheme.background,
    ) { slidesContent ->
        CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onBackground) {
            slidesContent()
        }
    }
}

val slides = Slides(
    introCuP,
    whatAndWhy,
    configuration
)
