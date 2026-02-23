package com.bcnkode.meetup.layouts

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bcnkode.meetup.Sizes

@Composable
fun Pane(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = RoundedCornerShape(Sizes.roundedCorners),
        modifier = modifier,
    ) {
        content()
    }
}
