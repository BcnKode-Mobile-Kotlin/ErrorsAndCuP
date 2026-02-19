package com.bcnkode.meetup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SlideScaffold(
    title: String,
    subtitle: String? = null,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(Sizes.screenSidePadding)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.displayLarge,
        )

        if (subtitle != null) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.secondary,
            )
        }

        Box(
            contentAlignment = contentAlignment,
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp),
        ) {
            content()
        }
    }
}
