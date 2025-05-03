package me.davidcosta.movio.core.components.poster

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Poster
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.shapes

@Composable
fun DSPoster(
    modifier: Modifier = Modifier,
    posterData: Poster,
    posterSize: DSPosterSize = DSPosterSize.Small,
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
                shape = DS.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(posterSize.height)
            ) {
                AsyncImage(
                    model = posterData.posterPath,
                    contentScale = ContentScale.Crop,
                    contentDescription = stringResource(
                        R.string.poster_content_description_image,
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
fun PreviewDSPoster() {
    AppTheme (changeSystemBarStyle = false) {
        DSPoster(
            posterData = Poster(
                id = 1,
                title = "Adolescense",
                posterPath = "poster.jpg"
            )
        )
    }
}