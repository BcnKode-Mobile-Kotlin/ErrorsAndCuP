package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.Sizes
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.eh_railway
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import org.jetbrains.compose.resources.painterResource

val introErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    )
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(Sizes.screenSidePadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(36.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = styled { "Errors in Kotlin\n${+i}beyond try-catch${-i}" },
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = "by BcnKode: Mobile & Kotlin",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Medium,
            )
        }
        Image(
            painter = painterResource(Res.drawable.eh_railway),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
            modifier = Modifier.clip(CircleShape).weight(1f)
        )
    }
}
