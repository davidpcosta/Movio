package me.davidcosta.movio.core.components.core

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.davidcosta.movio.R
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.Icons
import me.davidcosta.movio.core.theme.spacing

@Composable
fun ScoreComp(
    modifier: Modifier = Modifier,
    scoreData: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.StarRate,
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = stringResource(R.string.movie_detail_screen_content_description_icon_rate),
            modifier = Modifier
                .size(16.dp)
                .padding(end = MaterialTheme.spacing.tiny)
        )
        Text(
            text = scoreData,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview
@Composable
fun PreviewScoreComp() {
    AppTheme(changeSystemBarStyle = false) {
        ScoreComp(
            scoreData = "9,8"
        )
    }
}
