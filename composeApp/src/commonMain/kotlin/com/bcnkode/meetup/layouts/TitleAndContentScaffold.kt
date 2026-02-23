package com.bcnkode.meetup.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.bcnkode.meetup.Sizes

@Composable
fun TitleAndContentScaffold(
    title: String,
    subtitle: String? = null,
    contentAlignment: Alignment = Alignment.TopStart,
    contentHorizontalPadding: Dp = Sizes.screenSidePadding,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Sizes.smallItemSpacing),
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
            .padding(vertical = Sizes.screenSidePadding),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(horizontal = contentHorizontalPadding),
        )

        if (subtitle != null) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(horizontal = contentHorizontalPadding),
            )
        }

        Box(
            contentAlignment = contentAlignment,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(top = Sizes.titleToContent)
                .padding(horizontal = contentHorizontalPadding),
        ) {
            content()
        }
    }
}
