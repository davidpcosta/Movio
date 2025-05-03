package me.davidcosta.movio.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun AppTheme(
    changeSystemBarStyle: Boolean = true,
    content: @Composable () -> Unit
) {
    if (changeSystemBarStyle) {
        SystemBarsColorChanger()
    }
    CompositionLocalProvider(
        LocalSpacing provides CustomSpacing()
    ) {
        MaterialTheme(
            colorScheme = ColorScheme,
            typography = Typography,
            content = content
        )
    }
}