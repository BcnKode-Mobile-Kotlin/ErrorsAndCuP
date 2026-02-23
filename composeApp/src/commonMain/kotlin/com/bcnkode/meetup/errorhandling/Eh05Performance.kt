package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.MyStyleSheet
import com.bcnkode.meetup.SlideScaffold
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled

val performanceErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
) {
    TitleAndContentScaffold(
        title = "History",
        subtitle = "Performance",
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
        ) {

            Text("Exceptions are expensive")
            Spacer(Modifier.height(16.dp))
            Text(styled(MyStyleSheet) { "Instantiating a ${+code}Throwable${-code} requires capturing a snapshot of the thread to populate the stacktrace." })
            // TODO consider adding an image
        }
    }
}
