package me.davidcosta.movio.core.theme

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


@Composable
fun SystemBarsColorChanger() {
    val window = (LocalContext.current as Activity).window
    val view = LocalView.current

    WindowCompat.getInsetsController(window, view).apply {
        isAppearanceLightStatusBars = false
        isAppearanceLightNavigationBars = false
    }
}