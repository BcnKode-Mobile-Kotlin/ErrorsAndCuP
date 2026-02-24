package com.bcnkode.meetup.cup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.composables.Code
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val sourceCodeMarkersCuP by Slide(
    stepCount = 5,
    user = SpeakerNotes(
        """
            (Paso 0) 1. La receta mágica:
            Enseñar código está bien, pero guiar la mirada del público es mejor. Para hacer eso en CuP, declaramos 
            "marcadores" (markers). Fijaos en el código: creamos variables como hello usando onlyShown 
            (solo se muestra en ciertos pasos), hey usando hidden (se oculta en un paso), o goodbye usando highlighted.
            Luego, simplemente envolvemos nuestras líneas de código entre esa variable y una equis ${'$'}{X} que actúa como cierre.

            (Paso 1) 2. El resultado (Estado base):
            (Clic para ocultar la receta y mostrar el Output)
            Vale, vamos a ver esto en acción. Aquí tenemos nuestras 3 líneas de código impresas en pantalla. Ahora mismo estamos en el paso 1 de nuestro bloque de código.

            (Paso 2) 3. Jugando con la visibilidad (onlyShown):
            (Clic para ocultar el Hello World)
            Como le dijimos a nuestro marcador hello que NO se mostrara en el paso 2, el texto desaparece y el bloque de 
            código se contrae fluidamente hacia arriba. ¡Adiós al "Hello World"!

            (Paso 3) 4. Alternando líneas (hidden):
            (Clic para volver a mostrar Hello y ocultar Hey)
            Si avanzamos otro paso, el "Hello" vuelve, pero ahora es el "Hey World!" el que desaparece porque le pusimos 
            la condición hidden. El código se reajusta solo.

            (Paso 4) 5. El Resaltado (highlighted):
            (Clic para hacer el highlight de Goodbye)
            Y mi favorito personal para explicar código complejo. Si usamos el marcador highlighted, en lugar de 
            desaparecer, el resto del código se atenúa (fade) y el foco visual se va directo a la línea que queremos 
            explicar. Es como tener un puntero láser integrado en el IDE.
        """.trimIndent()
    )
) { step ->
    TitleAndContentScaffold(
        title = "Source code",
        subtitle = "Animate code"
    ) {
        val sourceCode = rememberSourceCode(language = "kotlin") {
            """
            val sourceCode = rememberSourceCode(language = "kotlin") {
                val hello by marker(onlyShow(0, 2))
                val hey by marker(hidden(1))
                val goodbye by marker(highlighted(2))
                ${"\"\"\""}
                fun main() {
                    ${"\${hello}"}println("Hello World!")${"\${X}"}
                    ${"\${hey}"}println("Hey World!")${"\${X}"}
                    ${"\${goodbye}"}println("Goodbye World!")${"\${X}"}
                }
                ${"\"\"\""}.trimIndent()
            }
        """.trimIndent()
        }
        val outputCode = rememberSourceCode(language = "kotlin") {
            val hello by marker(onlyShown(1, 3, 4))
            val hey by marker(hidden(3))
            val goodbye by marker(highlighted(4))
            """
                fun main() {
                    ${hello}println("Hello World!")${X}
                    ${hey}println("Hey World!")${X}
                    ${goodbye}println("Goodbye World!")${X}
                }
            """.trimIndent()
        }
        Column {
            if (step == 0) {
                CodeInPaneWithTitle(
                    title = "This is the way to write code in CuP",
                    code = sourceCode
                )
                Spacer(Modifier.height(20.dp))
            }
            AnimatedVisibility(step >= 1) {
                Column {
                    Text(text = "The output is this:", style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(8.dp))
                    Code(outputCode, step = step)
                }
            }
        }
    }
}