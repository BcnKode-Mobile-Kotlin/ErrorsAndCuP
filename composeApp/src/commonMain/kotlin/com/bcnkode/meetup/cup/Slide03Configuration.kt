package com.bcnkode.meetup.cup

import com.bcnkode.meetup.SlideScaffold
import net.kodein.cup.PreparedSlide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val configuration by PreparedSlide(
    stepCount = 2,
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
) {
    val sourceCode = rememberSourceCode(language = "gradle") {
        val plugin by marker(onlyShown(0))
        val implementations by marker(onlyShown(1))

        """
        ${plugin}plugins {
            alias(libs.plugins.cup)
        }
                    
        cup {
            targetDesktop()
            targetWeb()
        }${X}
        
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
    slideContent { step ->
        SlideScaffold(title = "Configuración") {
            SourceCode(
                sourceCode = sourceCode,
                step = step,
                theme = SourceCodeThemes.darcula
            )
        }
    }
}