package io.tasky.taskyapp.core.util

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun Modifier.shimmerAnimation(): Modifier = composed {
    val colors = if (isSystemInDarkTheme()) {
        listOf(
            Color.DarkGray.copy(alpha = 0.7F),
            Color.DarkGray.copy(alpha = 0.2F),
            Color.DarkGray.copy(alpha = 0.7F),
        )
    } else {
        listOf(
            Color.LightGray.copy(alpha = 0.7F),
            Color.LightGray.copy(alpha = 0.2F),
            Color.LightGray.copy(alpha = 0.7F),
        )
    }
    val transition = rememberInfiniteTransition()
    val translateAnimation = transition.animateFloat(
        initialValue = 0F,
        targetValue = 1000F,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing,
            )
        )
    )
    val brush = Brush.linearGradient(
        colors,
        start = Offset.Zero,
        end = Offset(translateAnimation.value, translateAnimation.value)
    )

    background(brush)
}
