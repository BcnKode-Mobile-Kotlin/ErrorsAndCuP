package com.bcnkode.meetup.cup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.composables.CodeInPane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.SpanStyleSheet
import net.kodein.cup.ui.styled

val customStyleCuP by Slide(
    stepCount = 6,
    user = SpeakerNotes(
        """
        (Paso 0) 1. ¿Y si queremos más?:
        Ya hemos visto cómo usar negrita y cursiva, pero en la vida real tenemos manuales de marca. ¿Qué pasa si quiero 
        que un texto llame muchísimo la atención con varios estilos a la vez?
            
        (Paso 1) 2. El objetivo visual:
        (Clic para revelar el texto de ejemplo)
        Mirad este texto: queremos que una parte sea roja, esté en negrita y además esté subrayada. Si hacemos esto con 
        la forma clásica de Compose, volvemos al "infierno" del buildAnnotatedString enorme.

        (Paso 2) 3. El diccionario de estilos (StyleSheet):
        (Clic para revelar el código de MyStyleSheet)
        CuP nos permite crear un SpanStyleSheet. Pensad en esto como vuestro diccionario corporativo de estilos. 
        Registramos un marcador personalizado (en este caso lo llamamos red) y le asignamos un SpanStyle nativo de 
        Jetpack Compose con todos los atributos que queramos. ¡Podéis definir aquí todos los estilos de vuestra empresa!

        (Paso 3) 4. ¿Cómo lo aplicamos?:
        (Clic para revelar el segundo bloque de código)
        Ahora solo nos falta decirle a nuestro texto que utilice este nuevo diccionario.

        (Pasos 4 y 5) 5. Magia en acción:
        (Clic para resaltar las partes clave del código)
        Fijaos en lo que está resaltado. Primero, le pasamos nuestro MyStyleSheet a la función styled(). Y a partir de 
        ese momento... ¡boom! Ya podemos usar ${'$'}{+red} y ${'$'}{-red} dentro de nuestro string, exactamente igual 
        que usábamos la negrita estándar.

        6. Conclusión: Mantenemos la legibilidad perfecta de un string de una sola línea, pero aplicando combinaciones 
        de estilos hipercomplejas y reutilizables en toda la presentación.
        """.trimIndent()
    )
) { step ->
    val customStyleCode = rememberSourceCode(language = "kotlin") {
        """
            object MyStyleSheet : SpanStyleSheet() {
                val red by registerMarker(
                    SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        textDecoration = TextDecoration.Underline,
                    )
                )
            }
        """.trimIndent()
    }
    val textStyleCode = rememberSourceCode(language = "kotlin") {
        val highlight by marker(highlighted(4))
        """
            Text(
                ${highlight}styled(MyStyleSheet) {${X} "\"This is a ${highlight}${'$'}{+red}${X}red underlined text${highlight}${'$'}{-red}${X}\"" },
            )
        """.trimIndent()
    }

    TitleAndContentScaffold(
        title = "Styled text",
        subtitle = "Custom style"
    ) {
        Column {
            AnimatedVisibility(step >= 1) {
                Text(
                    styled(CustomSpanStyle) { "\"This is a ${+redUnderline}red underlined text${-redUnderline}\"" },
                )
            }
            Spacer(Modifier.height(16.dp))
            AnimatedVisibility(step >= 2) {
                Column {
                    CodeInPane(code = customStyleCode)
                    Spacer(Modifier.height(16.dp))
                    AnimatedVisibility(step >= 3) {
                        CodeInPane(code = textStyleCode, step = step)
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}

private object CustomSpanStyle : SpanStyleSheet() {
    val redUnderline by registerMarker(
        SpanStyle(
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            textDecoration = TextDecoration.Underline,
        )
    )
}
