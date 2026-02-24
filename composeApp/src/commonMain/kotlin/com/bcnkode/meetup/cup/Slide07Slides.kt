package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.layouts.Pane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.SlideSpecs
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val slidesCuP by Slide(
    stepCount = 4,
    specs = SlideSpecs(),
    user = SpeakerNotes(
        """
            (Paso 0) 1. La base mínima:
            Declarar una diapositiva es tan fácil como crear una variable delegada con by Slide. En este punto más básico, 
            solo necesitamos abrir el bloque para empezar a añadir contenido visual.

            (Paso 1) 2. Configuración individual:
            (Clic para revelar los parámetros)
            Pero claro, a veces una diapositiva necesita algo más. Aquí le podemos pasar parámetros específicos:
            
                - El stepCount nos dice cuántos clics tiene esta misma slide (como los que estamos haciendo ahora).
                - Los SlideSpecs nos permiten sobrescribir configuraciones globales, como las transiciones de entrada y salida o el tamaño.
                - Y el SpeakerNotes es donde escribo la "chuleta" que os estoy leyendo ahora mismo.

            (Paso 2) 3. El Contenido:
            (Clic para revelar SlideContent)
            Dentro de las llaves es donde ocurre la magia de verdad. Aquí es donde llamamos a nuestros componentes de 
            Jetpack Compose, nuestros Scaffolds, nuestras animaciones... el diseño que queramos que vea el público.

            (Paso 3) 4. Sobrescribiendo el Tema:
            (Clic para revelar MySecondTheme)
            Y un truco interesante: si en una diapositiva concreta (por ejemplo, una pantalla de error o una demo) 
            queréis romper con el tema global que vimos antes, podéis envolver el contenido en un segundo tema (
            MySecondTheme) y ¡pum! Esta diapositiva será diferente al resto de la charla sin afectar a las demás.
        """.trimIndent()
    )
) { step ->
    val slideSourceCode = rememberSourceCode(language = "kotlin") {
        val params by marker(hidden(0))
        val content by marker(hidden(0, 1))
        val themeOverride by marker(onlyShown(3))
        val indent by marker(onlyShown(3))
        """
            val slide1 by Slide(
            ${params}    stepCount = 3,
                specs = SlideSpecs(
                    size = DpSize.Unspecified,
                    startTransitions = TransitionSet.Unspecified,
                    endTransitions = TransitionSet.Unspecified
                )
                user = SpeakerNotes("This is a note"),${X}
            ) {
            ${themeOverride}    MySecondTheme {${X}
            ${indent}    ${X}   ${content}SlideContent()${X}
            ${themeOverride}    }${X}
            }
        """.trimIndent()
    }
    TitleAndContentScaffold(
        title = "Slides",
        subtitle = "Build a slide",
        contentAlignment = Alignment.Center,
    ) {
        Column(Modifier.fillMaxHeight()) {
            Spacer(Modifier.weight(3f))
            Pane(Modifier.align(Alignment.CenterHorizontally)) {
                SourceCode(
                    sourceCode = slideSourceCode,
                    step = step,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 8.sp),
                    theme = SourceCodeThemes.darcula,
                )
            }
            Spacer(Modifier.weight(3f))
        }
    }
}