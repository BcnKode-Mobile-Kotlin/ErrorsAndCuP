package com.bcnkode.meetup.cup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.layouts.Pane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.layouts.TwoPanes
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.widgets.material3.BulletPoints

val animatedContentCuP by Slide(
    stepCount = 5
) { step ->
    val sourceCode = rememberSourceCode(language = "kotlin") {
        val codeContent by marker(hidden(0))
        """
            val animatedContentSlide by Slide(
                stepCount = 3,
            ) { step ->
            ${codeContent}    BulletPoints {
                    BulletPoint {
                        Text(text = "Initial step")
                    }
                    BulletPoint(step >= 1) {
                        Text(text = "Step 1")
                    }
                }
                AnimatedVisibility(
                    visible = step >= 2,
                    enter = fadeIn(),
                    exit = fadeOut(),
                ) {
                    Text(text = "Step 2")
                }${X}
            }
        """.trimIndent()
    }
    TitleAndContentScaffold(
        title = "Content animation",
        contentAlignment = Alignment.Center,
    ) {
        TwoPanes(
            leftContent = {
                Column(Modifier.fillMaxHeight()) {
                    Spacer(Modifier.weight(3f))
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
            },
            rightContent = {
                Column(modifier = Modifier.padding(top = 20.dp)) {
                    if (step >= 1) {
                        Text("Result: ", style = MaterialTheme.typography.displayMedium)
                    }
                    Spacer(Modifier.height(16.dp))
                    BulletPoints {
                        BulletPoint(step >= 2) {
                            Text(text = "Initial step")
                        }
                        BulletPoint(visible = step >= 3) {
                            Text(text = "Step 1")
                        }
                    }
                    AnimatedVisibility(
                        visible = step >= 4,
                        modifier = Modifier.padding(top = 16.dp, start = 6.dp),
                        enter = fadeIn(),
                        exit = fadeOut(),
                    ) {
                        Text(text = "Step 2")
                    }
                }
            },
            leftPercentage = 0.6f,
            showRightPaneBackground = false,
        )
    }
}