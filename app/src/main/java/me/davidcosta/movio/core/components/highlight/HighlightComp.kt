package me.davidcosta.movio.core.components.highlight

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.davidcosta.movio.R
import me.davidcosta.movio.core.components.core.ScoreComp
import me.davidcosta.movio.core.domain.Title
import me.davidcosta.movio.core.utils.samples.SampleData
import me.davidcosta.movio.core.utils.samples.Title
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.spacing

@Composable
fun HighlightComp(
    modifier: Modifier = Modifier,
    titleData: Title
) {
    val width = dimensionResource(R.dimen.highlight_width)
    val height = dimensionResource(R.dimen.highlight_height)

    Box(
        modifier = modifier
    ) {
        Surface(
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            modifier = Modifier
                .width(width)
                .height(height)
        ) {
            AsyncImage(
                model = titleData.thumbPath,
                contentDescription = "Movie poster",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {  }
            )
            ScoreComp(
                scoreData = titleData.voteAverage,
                modifier = Modifier
                    .wrapContentSize(align = Alignment.TopEnd)
                    .padding(MaterialTheme.spacing.medium)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(gradient())
            ) {
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.medium)
                        .fillMaxSize()
                ) {
                    Text(
                        text = titleData.title,
                        style = MaterialTheme.typography.displaySmall,
                        maxLines = 2,
                        modifier = Modifier.padding(top = MaterialTheme.spacing.tiny)
                    )
                    Text(
                        text = titleData.releaseDate.year.toString(),
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(top = MaterialTheme.spacing.tiny)
                    )
                }
            }

        }
    }
}

@Composable
private fun gradient(): Brush {
    return Brush.linearGradient(
        colors = listOf(Color.Transparent, Color.Transparent, Color.Black),
        start = Offset.Zero,
        end =  Offset(0f, Float.POSITIVE_INFINITY)
    )
}


@Preview
@Composable
fun PreviewHighlightComp() {
    AppTheme(changeSystemBarStyle = false) {
        HighlightComp(
            titleData = SampleData.Title
        )
    }
}