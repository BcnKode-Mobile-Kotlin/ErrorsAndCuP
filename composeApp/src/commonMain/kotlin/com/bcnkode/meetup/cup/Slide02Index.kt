package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints

val slidesIndexCuP by Slide(
    user = SpeakerNotes(
        """
        
        """.trimIndent()
    )
) {
    TitleAndContentScaffold(
        title = "What we'll cover",
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
        ) {

            BulletPoints {
                BulletPoint {
                    Text(text = "What is and avantages")
                }
                BulletPoint {
                    Text(text = "Configuration")
                }
                BulletPoint {
                    Text(text = "CuP application")
                }
                BulletPoint {
                    Text(text = "Slides")
                }
                BulletPoint {
                    Text(text = "Source code")
                }
                BulletPoint {
                    Text(text = "Plugins")
                }
            }
        }
    }
}