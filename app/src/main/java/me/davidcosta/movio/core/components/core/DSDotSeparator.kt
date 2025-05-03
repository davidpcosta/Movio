package me.davidcosta.movio.core.components.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.color

@Composable
fun DSDotSeparator(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Box(
            Modifier.size(8.dp)
                .clip(CircleShape)
                .background(DS.color.primary)
        )
    }
}

@Preview
@Composable
fun PreviewDSDotSeparator() {
    AppTheme(changeSystemBarStyle = false) {
        DSDotSeparator()
    }
}