package me.davidcosta.movio.core.components.core

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.spacing

@Composable
fun GenreComp(
    modifier: Modifier = Modifier,
    text: String
) {
    Surface(
        shape = MaterialTheme.shapes.extraLarge,
        modifier = modifier
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.small
                )
        )
    }
}

@Preview
@Composable
fun GenreCompPreview() {
    AppTheme(changeSystemBarStyle = false) {
        GenreComp(
            text = "Genero"
        )
    }
}