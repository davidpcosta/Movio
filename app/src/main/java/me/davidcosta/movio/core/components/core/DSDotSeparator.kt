package me.davidcosta.movio.core.components.core

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DSDotSeparator(
    modifier: Modifier = Modifier
) {
    val color = MaterialTheme.colorScheme.primary
    Box(
        modifier = modifier
    ) {
        Canvas(
            modifier = Modifier.size(8.dp),
            onDraw = {
                drawCircle(
                    color = color,
                    radius = 8f
                )
            }
        )
    }
}