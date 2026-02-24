package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val genericTransitionsCuP by Slide(
    stepCount = 2,
    user = SpeakerNotes(
        """
            (Paso 0) 1. El salto entre pantallas:
            Hemos visto cómo animar elementos dentro de una diapositiva, pero ¿qué pasa cuando pasamos de la Slide 3 a l
            a Slide 4? Por defecto, CuP hace un desplazamiento lateral (como si pasáramos las páginas de un libro). 
            Pero a veces buscamos un estilo más cinematográfico o sutil.

            (Paso 1) 2. Configuración general (DRY):
            (Clic para resaltar el bloque de defaultSlideSpecs)
            Para cambiar esto, no tenemos que ir diapositiva por diapositiva. Volvemos a nuestro punto de entrada
             (el main()), y en el bloque de configuration de la presentación definimos los defaultSlideSpecs.

            3. ¿Qué podemos configurar aquí?:
                - El tamaño (Size): Podemos forzar que nuestra presentación sea panorámica (SLIDE_SIZE_16_9) o más cuadrada (4_3).
                - Las transiciones: Aquí le indicamos que el startTransitions y el endTransitions utilicen un TransitionSet.fade.

            4. Conclusión: Con estas 4 líneas de código centralizadas, a partir de ahora, toda nuestra presentación 
            hará un fundido suave y profesional entre diapositivas. El principio de Don't Repeat Yourself (DRY) aplicado 
            a las transiciones.
        """.trimIndent()
    )
) { step ->
    val sourceCode = rememberSourceCode(language = "kotlin") {
        val highlight by marker(highlighted(1))
        """
        fun main() = cupApplication {
            Presentation(
                slides = Slides(slides),
                configuration = {
        ${highlight}            defaultSlideSpecs = SlideSpecs(
                        size = SLIDE_SIZE_16_9,
                        startTransitions = TransitionSet.fade,
                        endTransitions = TransitionSet.fade,
                    )${X}
                }
            ) { slidesContent ->
                slidesContent()
            }
        }
    """.trimIndent()
    }

    TitleAndContentScaffold(
        title = "Transitions",
        subtitle = "Generic"
    ) {
        Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(3f))
            CodeInPaneWithTitle(
                title = "Set a generic transitions in the whole presentation",
                code = sourceCode,
                modifier = Modifier.fillMaxWidth(),
                step = step,
            )
            Spacer(Modifier.weight(3f))
        }
    }
}