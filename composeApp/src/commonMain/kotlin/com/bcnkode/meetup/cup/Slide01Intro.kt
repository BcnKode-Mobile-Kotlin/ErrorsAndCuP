package com.bcnkode.meetup.cup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.Sizes
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.cup
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import org.jetbrains.compose.resources.painterResource

val introCuP by Slide(
    user = SpeakerNotes(
        """
            Ahora os hablaremos de Compose Ur Pres. Seguramente deduzcáis cómo se han hecho estás presentaciones según
            el nombre de la siguiente charla.
            Efectivamente, estas slides estan hechas en Kotlin puro y con Compose Multiplatform. Basicamente, si sabéis
            utilizar Compose, sabréis hacer unas diapositivas espectaculares. Ahora vamos a ver como se puede montar todo
            esto.
        """.trimIndent()
    )
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(Sizes.screenSidePadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = styled { "Compose Ur Pres\n${+b}¡Slides in Kotlin!${-b}" },
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
