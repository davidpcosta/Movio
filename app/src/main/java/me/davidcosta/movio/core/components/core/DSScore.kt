package me.davidcosta.movio.core.components.core

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.davidcosta.movio.R
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.Icons
import me.davidcosta.movio.core.theme.color
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.theme.typography

@Composable
fun DSScore(
    modifier: Modifier = Modifier,
    scoreData: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.StarRate,
            tint = DS.color.primary,
            contentDescription = stringResource(R.string.movie_detail_screen_content_description_icon_rate),
            modifier = Modifier
                .size(16.dp)
                .padding(end = DS.spacing.tiny)
        )
        Text(
            text = scoreData,
            style = DS.typography.titleSmall
        )
    }
}

@Preview
@Composable
fun PreviewScoreComp() {
    AppTheme(changeSystemBarStyle = false) {
        DSScore(
            scoreData = "9,8"
        )
    }
}
