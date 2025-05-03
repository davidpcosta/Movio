package me.davidcosta.movio.core.components.core.tab

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.color

sealed class DSTabStyle {
    data object Primary : DSTabStyle()
    data object Secondary : DSTabStyle()
}

@Composable
fun DSTabStyle.color(): Color =
    when(this) {
        DSTabStyle.Primary -> DS.color.primary
        DSTabStyle.Secondary -> DS.color.onBackground
    }