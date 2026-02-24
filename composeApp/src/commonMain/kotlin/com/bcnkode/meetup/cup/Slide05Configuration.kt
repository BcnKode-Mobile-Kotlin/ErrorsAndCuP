package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.layouts.Pane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val configurationCuP by Slide(
    stepCount = 2,
    user = SpeakerNotes(
        """
            (Paso 0) 1. La configuración mínima viable:
            Como en cualquier proyecto moderno de Kotlin Multiplatform, todo empieza en nuestro querido build.gradle.kts. 
            Fijaros en lo limpio que es:

                - Aplicamos el plugin oficial de CuP.
                - Declaramos nuestros targets: en este caso le decimos que queremos exportar a Escritorio (targetDesktop) y a Web (targetWeb).
                - Y en nuestras dependencias comunes, simplemente añadimos Material 3 de Compose. ¡Con esto ya podríamos arrancar!

            (Paso 1) 2. Vitaminando la presentación (Los Plugins):
            (Clic para revelar el resto del código)
            Pero no queremos una presentación básica, queremos magia. CuP es totalmente modular, así que aquí añadimos las librerías extra que vamos a necesitar.
                
                - laser: Para tener un puntero láser en pantalla.
                - sourceCode: Que es, irónicamente, la librería que está pintando de colores este mismo bloque de código que estáis leyendo.
                - speakerWindow: La que me permite tener esta chuleta con notas en mi otra pantalla.

            Y utilidades extra como Emojis o Widgets. ¡Pones solo lo que necesitas y listo!
        """.trimIndent()
    ),
) { step ->
    val sourceCode = rememberSourceCode(language = "gradle") {
        val implementations by marker(onlyShown(1))

        """
        plugins {
            alias(libs.plugins.cup)
        }
                    
        cup {
            targetDesktop()
            targetWeb()
        }
        
        kotlin {
            sourceSets {
                commonMain.dependencies {
                    implementation(libs.compose.material3)
        ${implementations}    
                    implementation(libs.cup.laser)
                    implementation(libs.cup.sourceCode)
                    implementation(libs.cup.speakerWindow)
                    implementation(libs.cup.widgets.material3)
                    implementation(libs.emoji.compose)${X}
                }
            }
        }
        """.trimIndent()
    }
    TitleAndContentScaffold(
        title = "Configuration",
        contentAlignment = Alignment.Center,
    ) {
        Column(Modifier.fillMaxHeight()) {
            Spacer(Modifier.weight(3f))
            Text("build.gradle.kts")
            Spacer(Modifier.height(8.dp))
            Pane(Modifier.align(Alignment.CenterHorizontally)) {
                SourceCode(
                    sourceCode = sourceCode,
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