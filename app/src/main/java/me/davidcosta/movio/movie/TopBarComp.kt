package me.davidcosta.movio.movie

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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import me.davidcosta.movio.R
import me.davidcosta.movio.core.components.core.DSDotSeparator
import me.davidcosta.movio.core.components.core.DSTopBar
import me.davidcosta.movio.core.components.poster.DSPosterSize
import me.davidcosta.movio.core.domain.Movie
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.Icons
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.theme.typography
import me.davidcosta.movio.core.utils.orDefault

@ExperimentalMaterial3Api
@Composable
fun TopBarComp(
    scrollBehavior: TopAppBarScrollBehavior,
    movie: Movie?,
    navHostController: NavHostController
) {
    movie?.let {
        DSTopBar(
            scrollBehavior = scrollBehavior,
            navHostController = navHostController,
            collapsedTitle = movie.title,
            content = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                        .padding(end = 12.dp)
                ) {
                    Surface(
                        shape = MaterialTheme.shapes.large,
                    ) {
                        AsyncImage(
                            model = movie.posterPath,
                            contentScale = ContentScale.Crop,
                            contentDescription = stringResource(
                                R.string.poster_content_description_image,
                                movie.title
                            ),
                            modifier = Modifier
                                .width(DSPosterSize.Medium.width)
                                .height(DSPosterSize.Medium.height)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(top = DS.spacing.small)
                    ) {
                        Text(
                            text = movie.releaseYear.orDefault("-"),
                            style = DS.typography.titleMedium
                        )
                        DSDotSeparator(
                            modifier = Modifier
                                .padding(horizontal = DS.spacing.small)
                        )
                        Text(
                            text = movie.runtime,
                            style = MaterialTheme.typography.titleMedium
                        )
                        DSDotSeparator(
                            modifier = Modifier
                                .padding(horizontal = DS.spacing.small)
                        )
                        Icon(
                            imageVector = Icons.StarRate,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = stringResource(R.string.movie_detail_screen_content_description_icon_rate),
                            modifier = Modifier
                                .size(dimensionResource(R.dimen.movie_detail_icon_rate_size))
                                .padding(end = DS.spacing.small)
                        )
                        Text(
                            text = movie.voteAverage,
                            style = DS.typography.titleMedium
                        )
                    }
                }
            }
        )
    }
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
                originalTitle = "Adolescense",
                posterPath = "poster.jpg",
                releaseYear = "2025",
                overview = "A fada fala alfafa.",
                runtime = "1h56m",
                voteAverage = "2,9",
                genres = emptyList()
            ),
            navHostController = rememberNavController()
        )
    }
}