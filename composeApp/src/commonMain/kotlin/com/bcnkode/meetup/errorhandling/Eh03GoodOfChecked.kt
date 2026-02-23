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

val goodOfCheckedErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
) {
    TitleAndContentScaffold(
        title = "History",
        subtitle = "Good things about checked exceptions",
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
        ) {

            BulletPoints {
                BulletPoint {
                    Text(text = "Errors were explicit")
                }
                BulletPoint {
                    Text(text = "You were forced to handle errors")
                }
                BulletPoint {
                    Text(text = "Refactoring: if you added a new error, you had to handle it")
                }
            }
        }
    }
}
