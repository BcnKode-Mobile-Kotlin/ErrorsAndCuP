package com.bcnkode.meetup.cup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.SlideScaffold
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.cmp_logo
import meetup_cup.composeapp.generated.resources.kotlin_logo
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import net.kodein.cup.widgets.material3.BulletPoints
import org.jetbrains.compose.resources.painterResource

val whatAndWhy by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
    stepCount = 4,
) { step ->
    SlideScaffold(title = "Qué es y ventajas") {
        Column {
            Column {
                Text(
                    text = styled {
                        "${+b}CuP${-b} te ayuda a declarar tu presentacion en Kotlin usando Compose Multiplatform"
                    },
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.kotlin_logo),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                    )
                    Image(
                        painter = painterResource(Res.drawable.cmp_logo),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                    )
                }
            }
            if (step >= 1) {
                Text(
                    text = styled { "${+b}Ventajas${-b}" },
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(top = 20.dp, bottom = 12.dp)
                )
                BulletPoints {
                    BulletPoint(visible = step >= 1) {
                        Text(text = "Reutilización de componentes y/o estilo de tu UI o empresa")
                    }
                    BulletPoint(visible = step >= 2) {
                        Text(text = "Personalización de las animaciones")
                    }
                    BulletPoint(visible = step >= 3) {
                        Text(text = "Exportar a PDF o a una página web")
                    }
                }
            }
        }
    }
}