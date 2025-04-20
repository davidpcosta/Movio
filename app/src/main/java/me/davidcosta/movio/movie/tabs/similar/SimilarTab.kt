package me.davidcosta.movio.movie.tabs.similar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import me.davidcosta.movio.MovieDetailsScreenRoute
import me.davidcosta.movio.core.components.poster.PosterComp
import me.davidcosta.movio.core.components.poster.PosterSize
import me.davidcosta.movio.core.theme.spacing

@Composable
fun SimilarTab(
    navHostController: NavHostController
) {

    val similarViewModel = viewModel<SimilarViewModel>()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = PosterSize.Medium.width),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
        contentPadding = PaddingValues(
            horizontal = MaterialTheme.spacing.horizontalMargin,
            vertical = MaterialTheme.spacing.large
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        items(similarViewModel.similarMovies.value) { poster ->
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                PosterComp(posterData = poster, posterSize = PosterSize.Medium) { id ->
                    navHostController.navigate(
                        MovieDetailsScreenRoute(movieId = id)
                    )
                }
            }
        }
    }
}