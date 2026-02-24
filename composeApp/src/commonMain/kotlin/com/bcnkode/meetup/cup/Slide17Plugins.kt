package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.composables.CodeInPane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints

val pluginsCuP by Slide(
    user = SpeakerNotes(
        """
            1. Una arquitectura modular:
            Algo genial de CuP es que no te obliga a cargar código pesado si no lo vas a usar. Si quieres funcionalidades 
            extra para el día de la charla, simplemente las añades como plugins en el bloque de configuración del main, 
            como veis en el primer bloque de código. Hoy destacamos dos fundamentales.

            2. El Puntero Láser (Laser):
            (Si tienes el láser activado, muévelo por la pantalla ahora)
            Al añadir la función laser(), habilitamos un puntero virtual que controlamos con el ratón. 
            Es una tontería, pero si estás haciendo una charla en remoto por Zoom o Twitch, el público no ve tu mano 
            señalando la pantalla. Con esto, guías su mirada perfectamente por el código.

            3. La Pantalla de Ponente (Speaker Window):
            Esta es la salvación de cualquier orador. Al añadir speakerWindow(), CuP nos levanta una segunda ventana 
            (la que yo estoy mirando ahora mismo en mi portátil) con un cronómetro, la diapositiva actual, 
            la siguiente y, lo más importante, mis notas privadas.

            4. ¿Cómo escribimos las notas?:
            (Señala el segundo bloque de código)
            Y para meter esas notas privadas en esa segunda pantalla, es tan fácil como usar el parámetro 
            user = SpeakerNote("...") al declarar la diapositiva. Literalmente, todo este rollo que os estoy soltando 
            ahora mismo está escrito exactamente así en mi código fuente. ¡Es "Inception" de presentaciones!
        """.trimIndent()
    )
) {
    val code = rememberSourceCode(language = "kotlin") {
        """
            fun main() = cupApplication {
                Presentation(
                    configuration = {
                        laser()
                        speakerWindow()
                    }
                )
            }
        """.trimIndent()
    }
    val speakerNoteCode = rememberSourceCode(language = "kotlin") {
        """
            val slide by Slide(
                user = SpeakerNote("My private note")
            ) {
                ...
            }
        """.trimIndent()
    }
    TitleAndContentScaffold(
        title = "Plugins",
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            BulletPoints {
                BulletPoint {
                    Text("Laser")
                }
                BulletPoint {
                    Text("Speaker window")
                }
            }
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CodeInPane(code)
                Spacer(Modifier.width(8.dp))
                CodeInPane(speakerNoteCode)
            }
            Spacer(Modifier.weight(1f))
        }
    }
}