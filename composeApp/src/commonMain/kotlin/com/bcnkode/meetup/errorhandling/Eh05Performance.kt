package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.MyStyleSheet
import com.bcnkode.meetup.Sizes
import com.bcnkode.meetup.SlideScaffold
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.eh_nullpointer
import meetup_cup.composeapp.generated.resources.eh_railways_1
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import org.jetbrains.compose.resources.painterResource

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
            Spacer(Modifier.height(16.dp))
            Image(
                painter = painterResource(Res.drawable.eh_nullpointer),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.clip(RoundedCornerShape(Sizes.roundedCorners))
                    .align(Alignment.CenterHorizontally).height(120.dp),
            )
        }
    }
}
