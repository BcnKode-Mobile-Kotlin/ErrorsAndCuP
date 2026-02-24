package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.composables.Code
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.layouts.TwoPanes
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints

val layoutsCuP by Slide(
    user = SpeakerNotes(
        """
            1. El código (Mirando a la derecha):
            Hasta ahora hemos visto cómo poner texto y animaciones, pero si en cada diapositiva tuviéramos que programar 
            la cabecera, los márgenes y el logotipo... nos volveríamos locos. Para eso creamos componentes envolventes: 
            los Scaffolds. Fijaos en el código, simplemente llamamos a MyScaffold, le pasamos el título y dentro escupimos 
            el contenido.

            2. Las ventajas reales (Mirando a la izquierda):
            ¿Qué ganamos trabajando así?

                - Consistencia visual: El título siempre está en el mismo píxel. No hay saltos raros al pasar de diapositiva.
                - Cero Boilerplate: Me olvido de escribir Columns, Spacers y paddings de 16dp en cada maldito archivo.
                - Gestión del espacio: El propio Scaffold calcula el área segura para que mi contenido nunca pise el título o el pie de página.
                - Plantillas: Igual que en Keynote tienes "Diapositiva de Título" o "Dos Columnas", aquí te programas tus propios Scaffolds reutilizables.

            3. El truco final: De hecho, ¡esta misma diapositiva que estáis viendo está usando un Scaffold! Todo este 
            recuadro, el título superior y la división en dos paneles es un componente llamado TitleAndContentScaffold 
            que he programado una sola vez y reutilizado en toda la charla.
        """.trimIndent()
    )
) {
    val scaffoldCode = rememberSourceCode(language = "kotlin") {
        """
            val layoutSlide by Slide {
                MyScaffold(
                    title = "Slide title",
                    subtitle = "Slide subtitle"
                ) {
                    SlideContent()
                }
            }
        """.trimIndent()
    }
    TitleAndContentScaffold(
        title = "Layouts",
        subtitle = "Scaffolds"
    ) {
        TwoPanes(
            leftContent = {
                Column {
                    Spacer(Modifier.weight(1f))
                    Text("Adventatges of using scaffolds:")
                    Spacer(Modifier.height(16.dp))
                    BulletPoints {
                        BulletPoint {
                            Text("Visual consistency")
                        }
                        BulletPoint {
                            Text("Less boilerplate code")
                        }
                        BulletPoint {
                            Text("Automatic space management")
                        }
                        BulletPoint {
                            Text("Reuse template")
                        }
                    }
                    Spacer(Modifier.weight(1f))
                }
            },
            rightContent = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Code(scaffoldCode)
                }
            }
        )
    }
}