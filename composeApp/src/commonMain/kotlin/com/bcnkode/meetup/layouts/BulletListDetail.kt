package com.bcnkode.meetup.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import net.kodein.cup.widgets.foundation.BulletPointsBuilder
import net.kodein.cup.widgets.material3.BulletPoints

data class Bullet(
    val text: String,
    val content: @Composable () -> Unit,
)

@Composable
fun BulletListDetail(
    bullets: List<Bullet>,
    step: Int,
) {
    TwoPanes(
        leftContent = {
            BulletPoints {
                bullets.forEachIndexed { index, bullet ->
                    HighlightableBullet(
                        bullet.text,
                        step == index,
                    )
                }
            }
        },
        rightContent = {
            Box(
                Modifier.fillMaxSize().padding(16.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                bullets.getOrNull(step)?.content?.invoke()
            }
        },
    )
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
