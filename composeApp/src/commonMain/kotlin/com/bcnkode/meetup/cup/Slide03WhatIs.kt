package com.bcnkode.meetup.cup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.layouts.TwoPanes
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.cmp_logo
import meetup_cup.composeapp.generated.resources.kotlin_logo
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import org.jetbrains.compose.resources.painterResource

val whatIsCuP by Slide(
    user = SpeakerNotes(
        """
            1. Como veis en pantalla, CuP es una herramienta que nos permite "declarar" nuestras presentaciones. 
            Igual que declaramos la UI de una app, aquí declaramos diapositivas.

            2. Los dos pilares (señalando los logos): Todo esto se apoya en dos tecnologías que ya conocemos:
            Kotlin: Todo el tipado fuerte, funciones, colecciones y la elegancia del lenguaje están a nuestra disposición.
            Compose: Utilizamos exactamente los mismos componentes (Row, Column, Text, Modifier) 
            que usamos en nuestro día a día. ¡Curva de aprendizaje casi cero!

            3. Lo más espectacular de que esté basado en Compose Multiplatform es que nuestra 
            presentación es, literalmente, un software multiplataforma. La podemos compilar como aplicación de 
            escritorio (Mac/Windows), exportarla a la Web para compartirla, o incluso presentarla desde una app de Android.
        """.trimIndent()
    ),
) {
    TitleAndContentScaffold(
        title = "What is",
    ) {
        TwoPanes(
            leftContent = {
                Text(
                    text = styled {
                        "${+b}CuP${-b} helps you declare your presentation in Kotlin using Compose Multiplatform"
                    },
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            },
            rightContent = {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(Res.drawable.kotlin_logo),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(Res.drawable.cmp_logo),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                    )
                }
            },
        )
    }
}