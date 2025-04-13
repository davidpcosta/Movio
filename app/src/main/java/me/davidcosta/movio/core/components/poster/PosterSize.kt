package me.davidcosta.movio.core.components.poster

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class PosterSize(val width: Dp, val height: Dp) {
    data object Small : PosterSize(92.dp, 138.dp)
    data object Medium : PosterSize(160.dp, 240.dp)
}