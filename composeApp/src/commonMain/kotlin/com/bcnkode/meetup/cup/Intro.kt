package com.bcnkode.meetup.cup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.cup
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import org.jetbrains.compose.resources.painterResource

val introCuP by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    )
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = styled { "Compose Ur Pres\n${+b}¡Slides en Kotlin!${-b}" },
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
            painter = painterResource(Res.drawable.cup),
            contentDescription = null,
            modifier = Modifier.clip(CircleShape)
        )
    }
}
