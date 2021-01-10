package io.github.muth0mi.bibilia.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = maroon,
    onPrimary = white,

    secondary = teal200,
    onSecondary = black,

    background = black,
    onBackground = white,

    surface = black,
    onSurface = white
)

private val LightColorPalette = lightColors(
    primary = maroon,
    onPrimary = white,

    secondary = teal200,
    onSecondary = black,

    background = white,
    onBackground = black,

    surface = white,
    onSurface = black
)

@Composable
fun MyApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (isSystemInDarkTheme()) DarkColorPalette else LightColorPalette,
        typography = typography,
        shapes = shapes,
        content = content
    )
}