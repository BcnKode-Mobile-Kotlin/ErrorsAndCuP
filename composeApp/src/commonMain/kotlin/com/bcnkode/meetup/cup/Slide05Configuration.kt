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