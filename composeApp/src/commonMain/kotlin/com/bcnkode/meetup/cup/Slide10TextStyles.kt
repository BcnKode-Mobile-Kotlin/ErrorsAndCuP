package com.bcnkode.meetup.cup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled

val styleCuP by Slide(
    stepCount = 5,
    user = SpeakerNotes(
        """
        (Paso 0) 1. El problema del formato:
        Escribir texto plano está muy bien, pero en una presentación a menudo necesitamos destacar cosas: negritas, 
        cursivas, colores... ¿Cómo lo hacemos aquí si todo es código?

        (Paso 1) 2. El objetivo visual:
        (Clic para revelar el texto de ejemplo)
        Supongamos que queremos pintar exactamente esto en pantalla: la frase "Hello, my friend" pero con el "my friend" 
        en negrita. Algo súper básico.

        (Paso 2) 3. La forma clásica (El drama):
        (Clic para revelar el código de Jetpack Compose)
        Si usamos el Jetpack Compose estándar que hacemos en nuestras apps, nos toca montar este drama: abrir un 
        buildAnnotatedString, hacer un append de la primera parte, abrir un bloque withStyle pasándole un SpanStyle con 
        el FontWeight, hacer otro append... ¡8 líneas de código para poner dos palabras en negrita! Una locura si 
        tienes que escribir 50 diapositivas.

        (Paso 3) 4. La forma CuP (La magia):
        (Clic para revelar el código de CuP)
        Por suerte, los creadores de Compose Ur Pres nos traen la función styled. Fijaos qué maravilla: 
        usamos interpolación de strings pura de Kotlin. Con ${'$'}{+b} encendemos la negrita y con ${'$'}{-b} la apagamos. 
        Literalmente, hemos pasado de 8 líneas a 1 sola línea súper legible.

        (Paso 4) 5. Superpoderes extra:
        (Clic para revelar los ejemplos de bold e italic)
        Y por supuesto, esto no se queda en la negrita. Tenemos atajos rápidos para cursiva (+i, -i).
        """.trimIndent()
    )
) { step ->
    val jetpackComposeStyleCode = rememberSourceCode(language = "kotlin") {
        """
            Text(
                text = buildAnnotatedString {
                    append("\"Hello, ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("my friend")
                    }
                    append("\"")
                }
            )
        """.trimIndent()
    }
    val cupStyleCode = rememberSourceCode(language = "kotlin") {
        """
            Text(text = styled { "\"Hello, ${'$'}{+b}my friend${'$'}{-b}\"" })
        """.trimIndent()
    }

    TitleAndContentScaffold(
        title = "Styled text",
        subtitle = "Jetpack compose form vs CuP form"
    ) {
        Column {
            AnimatedVisibility(step >= 1) {
                Text(
                    styled { "\"Hello, ${+b}my friend${-b}\"" },
                )
            }
            Spacer(Modifier.height(16.dp))
            AnimatedVisibility(step >= 2) {
                Column {
                    CodeInPaneWithTitle(
                        title = "Jetpack compose style:",
                        code = jetpackComposeStyleCode,
                    )
                }
            }
            Spacer(Modifier.height(16.dp))
            AnimatedVisibility(step >= 3) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Column {
                        CodeInPaneWithTitle(
                            title = "CuP style",
                            code = cupStyleCode,
                        )
                    }
                    Spacer(Modifier.width(16.dp))
                    AnimatedVisibility(
                        visible = step >= 4,
                        enter = fadeIn(),
                        exit = fadeOut(),
                    ) {
                        Column {
                            Text(text = styled { "b = ${+b}bold${-b}" })
                            Text(text = styled { "i = ${+i}italic${-i}" })
                        }
                    }
                }
            }
        }
    }
}
