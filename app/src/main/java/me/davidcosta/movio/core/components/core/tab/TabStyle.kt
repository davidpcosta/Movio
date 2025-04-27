package me.davidcosta.movio.core.components.core.tab

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

sealed class TabStyle {
    data object Primary : TabStyle()
    data object Secondary : TabStyle()
}

@Composable
fun TabStyle.color(): Color =
    when(this) {
        TabStyle.Primary -> MaterialTheme.colorScheme.primary
        TabStyle.Secondary -> MaterialTheme.colorScheme.onBackground
    }