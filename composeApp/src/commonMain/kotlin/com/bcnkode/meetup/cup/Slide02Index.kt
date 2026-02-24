package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints

val slidesIndexCuP by Slide(
    user = SpeakerNotes(
        """
        1. Qué es y por qué (What is and why): Empezaremos definiendo qué es exactamente Compose Ur Pres y, 
        lo más importante, cuándo tiene sentido usarlo en lugar de un PowerPoint tradicional de toda la vida.

        2. Configuración y App (Configuration & CuP application): Veremos rápidamente cómo se inicializa un proyecto y 
        cuál es la estructura principal (el main) que levanta toda la presentación.

        3. Diapositivas (Slides): Nos meteremos en el barro. Os enseñaré cómo creamos la interfaz visual de una 
        diapositiva utilizando los mismos componentes de Jetpack Compose y las ventajas de la libreria.

        4. Código fuente (Source code): La killer feature de esta herramienta. Aprenderemos a incrustar bloques de 
        código y a animarlos paso a paso para que el público no se maree leyendo.

        5. Plugins: Y para terminar, veremos esos superpoderes extra que nos da la comunidad, como esta misma pantalla 
        de notas de orador que estoy leyendo yo ahora mismo, punteros láser o cómo exportarlo a PDF o Web
        """.trimIndent()
    )
) {
    TitleAndContentScaffold(
        title = "What we'll cover",
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
        ) {

            BulletPoints {
                BulletPoint {
                    Text(text = "What is and why")
                }
                BulletPoint {
                    Text(text = "Configuration")
                }
                BulletPoint {
                    Text(text = "CuP application")
                }
                BulletPoint {
                    Text(text = "Slides")
                }
                BulletPoint {
                    Text(text = "Source code")
                }
                BulletPoint {
                    Text(text = "Plugins")
                }
            }
        }
    }
}