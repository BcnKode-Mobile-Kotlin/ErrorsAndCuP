package com.bcnkode.meetup.utils

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun Modifier.showIf(
    isVisible: Boolean,
    durationMillis: Int = 500
): Modifier {
    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = durationMillis),
        label = "alphaAnimation"
    )

    return this.graphicsLayer { this.alpha = alpha }
}
