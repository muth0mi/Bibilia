package io.github.muth0mi.bibilia.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val maroon = Color(0xFF801C17)
val teal200 = Color(0xFF03DAC5)

val white = Color(0xFFFFFFFF)
val black = Color(0xFF1B1C1E)

val DarkColorPalette = darkColors(
    primary = maroon,
    onPrimary = white,

    secondary = teal200,
    onSecondary = black,

    background = black,
    onBackground = white,

    surface = black,
    onSurface = white
)

val LightColorPalette = lightColors(
    primary = maroon,
    onPrimary = white,

    secondary = teal200,
    onSecondary = black,

    background = white,
    onBackground = black,

    surface = white,
    onSurface = black
)