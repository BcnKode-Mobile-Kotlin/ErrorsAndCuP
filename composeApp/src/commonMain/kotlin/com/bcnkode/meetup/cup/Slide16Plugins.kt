package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bcnkode.meetup.composables.Code
import com.bcnkode.meetup.composables.CodeInPane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.widgets.material3.BulletPoints

val pluginsCuP by Slide {
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
            CodeInPane(code, modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(Modifier.weight(1f))
        }
    }
}