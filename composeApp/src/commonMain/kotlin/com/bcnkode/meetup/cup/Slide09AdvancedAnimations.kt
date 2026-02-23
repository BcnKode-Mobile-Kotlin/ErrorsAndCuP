package com.bcnkode.meetup.cup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.cmp_chart
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource

val advancedAnimationsCuP by Slide(
    stepCount = 2,
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    )
) { step ->
    TitleAndContentScaffold(
        title = "Advanced animations",
        subtitle = "Example: From image to Compose with AI"
    ) {
        if (step == 0)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ){
            Image(
                painter = painterResource(Res.drawable.cmp_chart),
                contentDescription = null,
                modifier = Modifier.scale(1.5f)
            )
        }
        AnimatedVisibility(
            visible = step > 0,
            enter = fadeIn(
                tween(durationMillis = STORY_LINE_ANIMATION_MILLIS)
            ) + expandVertically(
                tween(durationMillis = STORY_LINE_ANIMATION_MILLIS)
            ),
            exit = fadeOut(),
        ) {
            Storyline(
                maskRevealInitialDelay = STORY_LINE_ANIMATION_MILLIS + 500,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

// Using slightly desaturated versions of the requested colors
private val BlueAlpha = Color(0xFF5C78C1)   // Muted Blue
private val GreenBeta = Color(0xFF8DA36C)   // Muted Green
private val MagentaStable = Color(0xFF7B2E86) // Muted Magenta
private val RowHeight = 14.dp

@Composable
fun Storyline(
    maskRevealInitialDelay: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        Column {
            // 1. Legend Row
            LegendRow()

            Spacer(modifier = Modifier.height(16.dp))

            // 2. The Main Chart Area
            BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                val chartWidth = maxWidth
                val labelWidth = 100.dp
                val timelineWidth = chartWidth - labelWidth

                // Define Time Range: 2021 Q3 -> 2025 Q4 (approx 18 Quarters)
                val totalQuarters = 18f

                // --- ANIMATION STATE ---
                // Stores the "Current Time" cursor in Quarters (0.0 -> 18.0)
                val animatedQuarter = remember { Animatable(0f) }

                // Trigger animation when component loads
                LaunchedEffect(Unit) {
                    animatedQuarter.animateTo(
                        targetValue = totalQuarters,
                        animationSpec = tween(
                            durationMillis = 3000, // 3 seconds to play the full timeline
                            delayMillis = maskRevealInitialDelay,
                            easing = LinearEasing
                        )
                    )
                }

                Row {
                    // LEFT COLUMN: Labels
                    Column(
                        modifier = Modifier
                            .width(labelWidth)
                            .padding(top = 24.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        PlatformText("Android")
                        PlatformText("Desktop")
                        PlatformText("iOS")
                        PlatformText("WASM")
                        PlatformText("Web Js")
                    }

                    // RIGHT COLUMN: Timeline
                    Box(modifier = Modifier.width(timelineWidth)) {

                        // Layer A: The Grid Lines (Static - Always visible)
                        TimelineBackground(totalQuarters = totalQuarters, width = timelineWidth)

                        // Layer B: The Bars (Animated - Revealed over time)
                        // We wrap the entire Column of bars in our RevealMask
                        RevealMask(
                            currentQuarter = animatedQuarter.value,
                            totalQuarters = totalQuarters,
                            totalWidth = timelineWidth
                        ) {
                            Column(
                                modifier = Modifier.padding(top = 24.dp),
                                verticalArrangement = Arrangement.spacedBy(20.dp)
                            ) {
                                val qW = timelineWidth / totalQuarters

                                // Android
                                BarRow(height = RowHeight) {
                                    Segment(BlueAlpha, width = qW * 1f)
                                    Segment(GreenBeta, width = qW * 1f)
                                    Segment(
                                        MagentaStable,
                                        width = timelineWidth - (qW * 2f)
                                    )
                                }

                                // Desktop
                                BarRow(height = RowHeight) {
                                    Segment(BlueAlpha, width = qW * 1f)
                                    Segment(GreenBeta, width = qW * 1f)
                                    Segment(
                                        MagentaStable,
                                        width = timelineWidth - (qW * 2f)
                                    )
                                }

                                // iOS
                                BarRow(height = RowHeight) {
                                    Spacer(modifier = Modifier.width(qW * 7.5f))
                                    Segment(BlueAlpha, width = qW * 4f)
                                    Segment(GreenBeta, width = qW * 4f)
                                    Segment(
                                        MagentaStable,
                                        width = timelineWidth - (qW * 8f)
                                    )
                                }

                                // WASM
                                BarRow(height = RowHeight) {
                                    Spacer(modifier = Modifier.width(qW * 11.5f))
                                    Segment(BlueAlpha, width = qW * 4.5f)
                                    Segment(GreenBeta, width = timelineWidth - (qW * 4.5f))
                                }

                                // Web JS
                                BarRow(height = RowHeight) {
                                    Segment(BlueAlpha, width = qW * 1f)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

// --- Animation Helper ---

@Composable
fun RevealMask(
    currentQuarter: Float,
    totalQuarters: Float,
    totalWidth: Dp,
    content: @Composable () -> Unit
) {
    // Calculate the pixel width that should be visible right now
    // We strictly convert quarters to pixels
    val visibleRatio = (currentQuarter / totalQuarters).coerceIn(0f, 1f)

    Box(
        modifier = Modifier
            .width(totalWidth)
            .drawWithContent {
                // Determine the width in pixels to reveal
                val revealPx = size.width * visibleRatio

                // Clip the content to a rectangle from 0 to revealPx
                clipRect(
                    left = 0f,
                    top = 0f,
                    right = revealPx,
                    bottom = size.height
                ) {
                    this@drawWithContent.drawContent()
                }
            }
    ) {
        content()
    }
}


// --- Existing Components (Unchanged) ---

@Composable
fun LegendRow() {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        LegendChip("Alpha", BlueAlpha)
        LegendChip("Beta", GreenBeta)
        LegendChip("Stable", MagentaStable)
    }
}

@Composable
fun LegendChip(text: String, color: Color) {
    Box(
        modifier = Modifier
            .background(color, RoundedCornerShape(6.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(text, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun PlatformText(text: String) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier.height(RowHeight)
    ) {
        Text(text, style = MaterialTheme.typography.bodyLarge, fontSize = 14.sp)
    }
}

@Composable
fun TimelineBackground(totalQuarters: Float, width: Dp) {
    val pxPerQuarter = with(LocalDensity.current) { (width / totalQuarters).toPx() }
    val height = 300.dp

    Box(modifier = Modifier.height(height).fillMaxWidth()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val dashEffect = PathEffect.dashPathEffect(floatArrayOf(5f, 10f), 0f)

            for (i in 0..totalQuarters.toInt()) {
                val x = i * pxPerQuarter

                drawLine(
                    color = Color.White.copy(alpha = 0.50f),
                    start = Offset(x, 20.dp.toPx()),
                    end = Offset(x, size.height),
                    pathEffect = dashEffect,
                    strokeWidth = 2f
                )
            }
        }

        @Composable
        fun YearLabel(text: String, quarterIndex: Float) {
            val offset = (width / totalQuarters) * quarterIndex
            Text(
                text = text,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 12.sp,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .absoluteOffset(x = offset)
                    .layout { measurable, constraints ->
                        val placeable = measurable.measure(constraints)
                        layout(placeable.width, placeable.height) {
                            placeable.place(x = -placeable.width / 2, y = 0)
                        }
                    }
            )
        }

        YearLabel("2021-Q3", 0f)
        YearLabel("2022", 2f)
        YearLabel("2023", 6f)
        YearLabel("2024", 10f)
        YearLabel("2025", 14f)
    }
}

@Composable
fun BarRow(height: Dp, content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier.height(height).fillMaxWidth(),
        content = content
    )
}

@Composable
fun Segment(color: Color, width: Dp) {
    Box(
        modifier = Modifier
            .width(width)
            .padding(end = 1.dp)
            .fillMaxHeight()
            .background(color, RoundedCornerShape(4.dp))
    )
}

private const val STORY_LINE_ANIMATION_MILLIS = 1000