package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.composables.Code
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.layouts.TwoPanes
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.widgets.material3.BulletPoints

val layoutsCuP by Slide {
    val scaffoldCode = rememberSourceCode(language = "kotlin") {
        """
            val layoutSlide by Slide {
                MyScaffold(
                    title = "Slide title",
                    subtitle = "Slide subtitle"
                ) {
                    SlideContent()
                }
            }
        """.trimIndent()
    }
    TitleAndContentScaffold(
        title = "Layouts",
        subtitle = "Scaffolds"
    ) {
        TwoPanes(
            leftContent = {
                Column {
                    Spacer(Modifier.weight(1f))
                    Text("Adventatges of using scaffolds:")
                    Spacer(Modifier.height(16.dp))
                    BulletPoints {
                        BulletPoint {
                            Text("Visual consistency")
                        }
                        BulletPoint {
                            Text("Less boilerplate code")
                        }
                        BulletPoint {
                            Text("Automatic space management")
                        }
                        BulletPoint {
                            Text("Reuse template")
                        }
                    }
                    Spacer(Modifier.weight(1f))
                }
            },
            rightContent = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Code(scaffoldCode)
                }
            }
        )
    }
}