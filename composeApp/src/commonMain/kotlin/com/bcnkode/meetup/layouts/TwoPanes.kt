package com.bcnkode.meetup.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bcnkode.meetup.Sizes

@Composable
fun TwoPanes(
    leftContent: @Composable () -> Unit,
    rightContent: @Composable () -> Unit,
    leftPercentage: Float = 0.4f,
    rightFillsHeight: Boolean = true,
    showRightPaneBackground: Boolean = true,
) {
    Row(
        Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(Modifier.weight(leftPercentage)) {
            leftContent()
        }
        Spacer(Modifier.width(Sizes.panesSeparation))
        if (showRightPaneBackground) {
            Pane(
                modifier = Modifier.weight(1 - leftPercentage).then(
                    if (rightFillsHeight) Modifier.fillMaxHeight() else Modifier
                ),
                content = rightContent,
            )
        } else {
            Box(
                modifier = Modifier.weight(1 - leftPercentage).then(
                    if (rightFillsHeight) Modifier.fillMaxHeight() else Modifier
                )
            ) {
                rightContent()
            }
        }
    }
}