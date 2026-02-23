package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.MyStyleSheet
import com.bcnkode.meetup.layouts.Pane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled

val logicOrExceptionsErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
) {
    TitleAndContentScaffold(
        title = "Present: modeling results",
        subtitle = "Should we avoid exceptions, then?",
    ) {
        Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(3f))

            Text(styled(MyStyleSheet) { "We use ${+code}exceptions${-code} for ${+b}unexpected errors${-b} that are ${+b}hard to recover from${-b}" })
            Spacer(Modifier.height(8.dp))
            Text("DatabaseConnectionLost, OutOfMemoryError...", style = MaterialTheme.typography.bodyMedium)

            Spacer(Modifier.weight(1f))

            Text(styled(MyStyleSheet) { "We use ${+code}types${-code} for ${+b}logic or domain errors${-b}" })
            Spacer(Modifier.height(8.dp))
            Text("UserNotFound, NoInternet, InvalidPassword...", style = MaterialTheme.typography.bodyMedium)

            Spacer(Modifier.weight(3f))
        }
    }
}
