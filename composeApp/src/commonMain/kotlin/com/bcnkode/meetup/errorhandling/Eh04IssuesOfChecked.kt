package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.MyStyleSheet
import com.bcnkode.meetup.SlideScaffold
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.layouts.TwoPanes
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import net.kodein.cup.widgets.foundation.BulletPointsBuilder
import net.kodein.cup.widgets.material3.BulletPoints

val issuesOfCheckedErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
    stepCount = 5,
) { step ->
    TitleAndContentScaffold(
        title = "History",
        subtitle = "Issues with checked exceptions",
    ) {
        TwoPanes(
            leftContent = {
                BulletPoints {
                    HighlightableBullet(
                        "Catch and ignore",
                        step == 0,
                    )
                    HighlightableBullet(
                        text = "Propagation",
                        step == 1,
                    )
                    HighlightableBullet(
                        "Functional issues",
                        step == 2,
                    )
                    HighlightableBullet(
                        "Adding exceptions",
                        step == 3,
                    )
                    HighlightableBullet(
                        "Where to catch",
                        step == 4,
                    )
                }
            },
            rightContent = {
                Box(
                    Modifier.fillMaxSize().padding(16.dp),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    when (step) {
                        0 -> Text("try-catch has boilerplate + being forced to handle exceptions = empty catch blocks") // TODO consider adding code
                        // TODO image?
                        1 -> Text("When you propagate an exception across layers, you handle a low level error (like IO) far from where it happens.")
                        2 -> Text("Lambdas in Java and Kotlin don't handle checked exceptions\n\nYou need to add the try-catch inside: boilerplate")// TODO add example
                        3 -> Text(styled(MyStyleSheet) { "You need to add ${+code}throws MyException${-code} in all layers until you handle your exceptions" })
                        4 -> Text("We have arrived to the conclusion that we should handle exceptions at the perimeter")
                    }
                }
            },
        )
    }
}

private fun BulletPointsBuilder.HighlightableBullet(text: String, isHighlighted: Boolean) {
    BulletPoint {
        Text(
            text,
            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = if (isHighlighted) 1f else 0.7f),
            modifier = Modifier.graphicsLayer(
                scaleX = if (isHighlighted) 1.1f else 1f,
                scaleY = if (isHighlighted) 1.1f else 1f,
                transformOrigin = TransformOrigin(0f, 0.5f),
            ),
        )
    }
}

private const val LEFT_WEIGHT = 0.4f
private const val RIGHT_WEIGHT = 1 - LEFT_WEIGHT