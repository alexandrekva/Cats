package com.example.cats.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = TurquoiseGreen,
    primaryVariant = RussianGreen,
    secondary = DeepChampagne,
    secondaryVariant = TerraCotta,
    background = Charcoal,
    onBackground = Cultured,
    surface = Charcoal,
    onSurface = Cultured,
    onSecondary = EerieBlack,
    onPrimary = EerieBlack,
    onError = Cultured,
    error = FireOpel

)

private val LightColorPalette = lightColors(
    primary = ForestGreen,
    primaryVariant = PhthaloGreen,
    secondary = Rajah,
    secondaryVariant = BurntOrange,
    background = Cultured,
    onBackground = EerieBlack,
    surface = Cultured,
    onSurface = EerieBlack,
    onSecondary = EerieBlack,
    onPrimary = Cultured,
    onError = Cultured,
    error = FireOpel
)

@Composable
fun CatsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}