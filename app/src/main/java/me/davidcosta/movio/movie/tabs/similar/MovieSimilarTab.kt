package me.davidcosta.movio.movie.tabs.similar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import me.davidcosta.movio.MovieScreenRoute
import me.davidcosta.movio.core.components.poster.DSPoster
import me.davidcosta.movio.core.components.poster.DSPosterSize
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.spacing

@Composable
fun MovieSimilarTab(
    navHostController: NavHostController
) {

    val movieSimilarViewModel = viewModel<MovieSimilarViewModel>()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = DSPosterSize.Medium.width),
        verticalArrangement = Arrangement.spacedBy(DS.spacing.small),
        horizontalArrangement = Arrangement.spacedBy(DS.spacing.small),
        contentPadding = PaddingValues(
            horizontal = DS.spacing.horizontalMargin,
            vertical = DS.spacing.large
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        items(movieSimilarViewModel.similarMovies.value) { poster ->
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                DSPoster(posterData = poster, posterSize = DSPosterSize.Medium) { id ->
                    navHostController.navigate(
                        MovieScreenRoute(movieId = id)
                    )
                }
            }
        }
    }
}