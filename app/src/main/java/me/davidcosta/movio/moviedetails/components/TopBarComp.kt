package me.davidcosta.movio.moviedetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.davidcosta.movio.R
import me.davidcosta.movio.core.components.core.DotSeparatorComp
import me.davidcosta.movio.core.domain.Movie
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.Icons
import me.davidcosta.movio.core.theme.StarRate
import me.davidcosta.movio.core.theme.spacing

@ExperimentalMaterial3Api
@Composable
fun TopBarComp(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    movie: Movie?
) {
    TopAppBar(
        title = {
            movie?.let {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                        .padding(end = 12.dp)
                ) {
                    Surface(
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier
                            .padding(top = MaterialTheme.spacing.large)
                    )  {
                        AsyncImage(
                            model = movie.posterPath,
                            contentScale = ContentScale.Crop,
                            contentDescription = stringResource(
                                R.string.poster_image_content_description,
                                movie.title
                            ),
                            modifier = Modifier
                                .width(dimensionResource(R.dimen.movie_detail_poster_width))
                                .height(dimensionResource(R.dimen.movie_detail_poster_height))
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(top = MaterialTheme.spacing.small)
                    ) {
                        Text(
                            text = movie.releaseYear,
                            style = MaterialTheme.typography.titleMedium
                        )
                        DotSeparatorComp(
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.small)
                        )
                        Text(
                            text = movie.runtime,
                            style = MaterialTheme.typography.titleMedium
                        )
                        DotSeparatorComp(
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.small)
                        )
                        Icon(
                            imageVector = Icons.StarRate,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = stringResource(R.string.movie_detail_screen_content_description_icon_rate),
                            modifier = Modifier
                                .size(dimensionResource(R.dimen.movie_detail_icon_rate_size))
                                .padding(end = MaterialTheme.spacing.small)
                        )
                        Text(
                            text = movie.voteAverage,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        },
        scrollBehavior = scrollBehavior,
        expandedHeight = 360.dp,
        colors = TopAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color.Transparent,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            actionIconContentColor = MaterialTheme.colorScheme.onBackground
        ),
        modifier = modifier
            .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun PreviewTopBarComp() {
    AppTheme(changeSystemBarStyle = false) {
        TopBarComp(
            scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
            movie = Movie(
                title = "Adolescense",
                posterPath = "poster.jpg",
                releaseYear = "2025",
                overview = "A fada fala alfafa.",
                runtime = "1h56m",
                voteAverage = "2,9",
                genres = emptyList()
            )
        )
    }
}