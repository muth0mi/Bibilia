package io.github.muth0mi.bibilia.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun BibiliaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (isSystemInDarkTheme()) DarkColorPalette else LightColorPalette,
        typography = BibiliaTypography,
        shapes = BibiliaShapes,
        content = content
    )
}