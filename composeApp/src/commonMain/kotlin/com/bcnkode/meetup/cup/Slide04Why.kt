package com.bcnkode.meetup.cup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.components.HighlightableBullet
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.layouts.TwoPanes
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.cmp_logo
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import net.kodein.cup.widgets.material3.BulletPoints
import org.jetbrains.compose.resources.painterResource
import org.kodein.emoji.Emoji
import org.kodein.emoji.travel_places.sky_weather.Fire

val advantagesCuP by Slide(
    user = SpeakerNotes(
        """
            1. Reutilización total de estilos: Aquí podemos importar directamente el sistema de diseño 
            (Design System) de nuestra app. Si vuestra empresa tiene un tema propio en Jetpack Compose, lo inyectáis 
            aquí y todas las slides heredan la identidad visual mágicamente.

            2. Animaciones sin límites:
            En una herramienta tradicional estás limitado al típico "fundido" o "deslizar". Aquí tenemos el motor de 
            Jetpack Compose entero a nuestra disposición. Podéis usar AnimatedVisibility, físicas de rebote (springs), 
            transiciones de estado... Si lo podéis imaginar e implementar en Android, lo podéis animar en vuestra 
            presentación.

            3. Exportación flexible:
            Que esté hecho en código no significa que se quede en vuestro IDE. La presentación se puede compilar a web 
            (Kotlin/Wasm o JS) para que cualquiera la vea desde su navegador mediante un link, o exportarse a un PDF 
            estático súper limpio para enviarlo por correo después de la charla.

            4. ¡Hot Reload!:
            Y esto es el paraíso del desarrollador (fijaros en el logo de Compose en llamas). Podéis tener vuestra 
            presentación corriendo en una ventana y el código en otra. Cambiáis un padding, un texto o un color, 
            le dais a guardar y... ¡Pum! Se actualiza en directo en la diapositiva sin tener que recompilar ni reiniciar la presentación.
        """.trimIndent()
    ),
    stepCount = 4,
) { step ->
    TitleAndContentScaffold(
        title = "Why use it",
    ) {
        TwoPanes(
            leftContent = {
                BulletPoints {
                    HighlightableBullet(
                        "Reuse styles and themes",
                        step == 0,
                    )
                    HighlightableBullet(
                        "Customizing animations",
                        step == 1,
                    )
                    HighlightableBullet(
                        "Export to different formats",
                        step == 2,
                    )
                    HighlightableBullet(
                        "Compatible with Hot Reload",
                        step == 3,
                    )
                }
            },
            rightContent = {
                Box(
                    Modifier.fillMaxSize().padding(16.dp),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    when (step) {
                        0 -> Text("Reuse of components and/or styles and themes of your UI or company")
                        1 -> Text("It allows you to use all the features of Jetpack Compose to customize your animations")
                        2 -> Text("It can be exported to formats such as PDF or as a web page.")
                        3 -> Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.cmp_logo),
                                contentDescription = null,
                                modifier = Modifier.size(64.dp),
                            )
                            Text(
                                text = styled { "${Emoji.Fire}" },
                                style = LocalTextStyle.current.copy(fontSize = 64.sp)
                            )
                        }
                    }
                }
            },
        )
    }
}