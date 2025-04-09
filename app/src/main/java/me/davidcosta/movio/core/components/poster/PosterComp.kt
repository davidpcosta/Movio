package me.davidcosta.movio.core.components.poster

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.davidcosta.movio.R
import me.davidcosta.movio.core.components.core.ScoreComp
import me.davidcosta.movio.core.domain.Poster
import me.davidcosta.movio.core.utils.samples.PosterList
import me.davidcosta.movio.core.utils.samples.SampleData
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.spacing


@Composable
fun PosterComp(
    modifier: Modifier = Modifier,
    posterData: Poster,
    onPosterClick: (Long) -> Unit = {}
) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .width(dimensionResource(R.dimen.poster_width))
        )
        {
            Surface (
                shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.poster_height))
            ) {
                AsyncImage(
                    model = posterData.posterPath,
                    contentScale = ContentScale.Crop,
                    contentDescription = stringResource(
                        R.string.poster_image_content_description,
                        posterData.title
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            onPosterClick(posterData.id)
                        }
                )
                ScoreComp(
                    scoreData = posterData.voteAverage,
                    modifier = Modifier
                        .wrapContentSize(align = Alignment.TopEnd)
                        .padding(MaterialTheme.spacing.medium)
                )
            }
            Text(
                text = posterData.title,
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 2,
                modifier = Modifier.padding(top = MaterialTheme.spacing.tiny)
            )
            Text(
                text = posterData.releaseDate.year.toString(),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.tiny)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPosterComp() {
    AppTheme (changeSystemBarStyle = false) {
        PosterComp(
            posterData = SampleData.PosterList.first()
        )
    }
}