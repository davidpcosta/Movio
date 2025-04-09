package me.davidcosta.movio.core.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class CustomSpacing (
    val tiny: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val toolbarComplement: Dp = 20.dp,
    val horizontalMargin: Dp = 16.dp
)

val LocalSpacing = staticCompositionLocalOf {
    CustomSpacing(
        small = Dp.Unspecified,
        medium = Dp.Unspecified,
        toolbarComplement = Dp.Unspecified,
        large = Dp.Unspecified,
        horizontalMargin = Dp.Unspecified
    )
}