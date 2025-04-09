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
fun ScoreComp(
    modifier: Modifier = Modifier,
    scoreData: String
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ){
        Text(
            text = scoreData,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(MaterialTheme.spacing.small)
        )
    }
}

@Preview
@Composable
fun PreviewScoreComp() {
    AppTheme(changeSystemBarStyle = false) {
        ScoreComp(
            scoreData = "9.8"
        )
    }
}
