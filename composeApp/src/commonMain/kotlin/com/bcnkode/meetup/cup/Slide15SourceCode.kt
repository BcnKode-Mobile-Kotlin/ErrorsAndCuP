package com.bcnkode.meetup.cup

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

val sourceCodeCuP by Slide(
    stepCount = 2,
    user = SpeakerNotes(
        """
            (Paso 0) 1. El terror de pegar código:
            Todos hemos estado ahí: tienes que enseñar código en Keynote, lo pegas, pierde el formato, el fondo se pone 
            blanco, intentas hacer una captura de pantalla del IDE, luego la estiras y se ve pixelada... Es un desastre.

            2. La receta nativa:
            Aquí lo hacemos de forma nativa. Fijaos en el bloque de arriba: usamos rememberSourceCode y le pasamos 
            nuestro código como un simple String multilínea de Kotlin. Luego le pasamos ese bloque a un componente 
            SourceCode donde elegimos el tamaño y el tema, como el mítico Darcula.

            (Paso 1) 3. El resultado final:
            (Clic para revelar el Output)
            Y este es el resultado. Un bloque de código con resaltado de sintaxis perfecto, renderizado vectorialmente 
            (adiós píxeles borrosos), y totalmente integrado en nuestro ecosistema Compose.

            4. Conclusión: Todo el código que habéis estado viendo hoy en esta charla está generado exactamente con este 
            mismo componente. ¡Cero capturas de pantalla!
        """.trimIndent()
    )
) { step ->
    val sourceCode = rememberSourceCode(language = "kotlin") {
        """
            val codeSlide by Slide {
                val sourceCode = rememberSourceCode(language = "kotlin") {
                    ${"\"\"\""}
                    fun main() {
                        println("Hello World!")
                    }
                    ${"\"\"\""}.trimIndent()
                }
                SourceCode(
                    code = sourceCode,
                    style = TextStyle(fontSize = 8.sp),
                    theme = SourceCodeThemes.darcula,
                )
            }
        """.trimIndent()
    }
    val outputCode = rememberSourceCode(language = "kotlin") {
        """
            fun main() {
                println("Hello World!")
            }
        """.trimIndent()
    }

    TitleAndContentScaffold(
        title = "Source code",
        subtitle = "Write code in CuP"
    ) {
        Column {
            if (step == 0) {
                CodeInPaneWithTitle(
                    title = "This is the way to write code in CuP",
                    code = sourceCode
                )
                Spacer(Modifier.height(20.dp))
            }
            if (step >= 1) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "The output is this:", style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(8.dp))
                    Code(outputCode)
                }
            }
        }
    }
}