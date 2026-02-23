package com.bcnkode.meetup.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import net.kodein.cup.widgets.foundation.BulletPointsBuilder

fun BulletPointsBuilder.HighlightableBullet(text: String, isHighlighted: Boolean) {
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