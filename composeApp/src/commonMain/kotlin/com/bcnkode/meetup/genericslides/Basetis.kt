package com.bcnkode.meetup.genericslides

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.Sizes
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.basetis_logo
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource

val basetis by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    )
) {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
            .padding(Sizes.screenSidePadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Spacer(Modifier.height(56.dp))
        Text(
            text = "BcnKode: Mobile & Kotlin",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(Modifier.height(32.dp))
        Text(
            text = "sponsored by",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Medium,
        )
        Spacer(Modifier.height(8.dp))
        Image(
            painter = painterResource(Res.drawable.basetis_logo),
            contentScale = ContentScale.FillHeight,
            contentDescription = null,
            modifier = Modifier.height(80.dp)
        )
    }
}
