package com.bcnkode.meetup.cup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.qr_code
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource
import org.kodein.emoji.Emoji
import org.kodein.emoji.smileys_emotion.heart.RedHeart

val finishCuP by Slide(
    user = SpeakerNotes(
        """
           1. El último truco de magia:
            Y para terminar, quiero recordaros una última vez la premisa de esta charla: esto no es un PowerPoint, 
            es una app de Android/Desktop ejecutándose en tiempo real.
            
            2. Interacción en vivo:
            (Mueve el ratón hacia el botón de la pantalla)
            Y como es una app real de Jetpack Compose, eso significa que podemos tener componentes interactivos con su 
            propio estado. Aquí tengo un simple Button que modifica un mutableStateOf al hacer clic. Vamos a pulsarlo...
            
            3. Despedida:
            (Haz clic en el botón para que aparezca el texto)
            ¡Ahí lo tenemos! Recomposición en directo para daros las gracias por escucharme este rato.
            
            4. Q&A:
            Ha sido un placer compartir esto con la comunidad de BcnKode. ¿Alguien tiene alguna pregunta, queja, 
            sugerencia o quiere ver algún trozo de código en detalle? ¡Disparad! 
        """.trimIndent()
    )
) {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(32.dp))
        Image(
            painter = painterResource(Res.drawable.qr_code),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(8.dp)),
        )
        var showGoodbye by remember { mutableStateOf(false) }
        Spacer(Modifier.height(32.dp))
        Text(
            text = "https://github.com/BcnKode-Mobile-Kotlin/ErrorsAndCuP.git",
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(Modifier.height(12.dp))
        Button(onClick = { showGoodbye = !showGoodbye }) {
            Text(text = "Click here!", color = MaterialTheme.colorScheme.background)
        }
        Spacer(Modifier.height(16.dp))
        AnimatedVisibility(showGoodbye) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Thank you so much ${Emoji.RedHeart}",
                    style = TextStyle(fontSize = 16.sp)
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Any questions?",
                    style = TextStyle(fontSize = 16.sp)
                )
            }
        }
    }
}