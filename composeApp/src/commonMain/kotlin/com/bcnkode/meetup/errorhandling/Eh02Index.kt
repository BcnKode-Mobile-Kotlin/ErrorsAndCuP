package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.SlideScaffold
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints

val indexErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
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
                    Text(text = "History: to understand why")
                }
                BulletPoint {
                    Text(text = "An opinionated present")
                }
                BulletPoint {
                    Text(text = "A bright future")
                }
            }
        }
    }
}
