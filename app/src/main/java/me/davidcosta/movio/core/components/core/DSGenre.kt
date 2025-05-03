package me.davidcosta.movio.core.components.core

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.color
import me.davidcosta.movio.core.theme.shapes
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.theme.typography

@Composable
fun DSGenre(
    modifier: Modifier = Modifier,
    text: String
) {
    Surface(
        shape = DS.shapes.extraLarge,
        color = DS.color.surfaceVariant,
        modifier = modifier
    ) {
        Text(
            text = text,
            style = DS.typography.titleSmall,
            modifier = Modifier
                .padding(
                    horizontal = DS.spacing.medium,
                    vertical = DS.spacing.tiny
                )
        )
    }
}

@Preview
@Composable
fun GenreCompPreview() {
    AppTheme(changeSystemBarStyle = false) {
        DSGenre(
            text = "Genero"
        )
    }
}