package me.davidcosta.movio.core.components.poster

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class DSPosterSize(val width: Dp, val height: Dp) {
    data object Small : DSPosterSize(92.dp, 138.dp)
    data object Medium : DSPosterSize(160.dp, 240.dp)
}