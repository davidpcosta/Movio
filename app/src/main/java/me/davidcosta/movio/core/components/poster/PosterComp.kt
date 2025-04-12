package me.davidcosta.movio.core.components.poster

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Poster
import me.davidcosta.movio.core.theme.AppTheme

sealed class PosterSize(val width: Dp, val height: Dp) {
    data object Small : PosterSize(92.dp, 138.dp)
    data object Medium : PosterSize(160.dp, 240.dp)
}

@Composable
fun PosterComp(
    modifier: Modifier = Modifier,
    posterData: Poster,
    posterSize: PosterSize = PosterSize.Small,
    onPosterClick: (Int) -> Unit = {}
) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .width(posterSize.width)
        )
        {
            Surface (
                shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(posterSize.height)
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
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPosterComp() {
    AppTheme (changeSystemBarStyle = false) {
        PosterComp(
            posterData = Poster(
                id = 1,
                title = "Adolescense",
                posterPath = "poster.jpg",
                voteAverage = "8,9",
                releaseYear = "2025"
            )
        )
    }
}