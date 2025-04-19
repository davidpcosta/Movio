package me.davidcosta.movio.home.tabs.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import me.davidcosta.movio.MovieDetailsScreen
import me.davidcosta.movio.R
import me.davidcosta.movio.core.components.poster.PosterRailComp

@Composable
fun MoviesTabComp(
    navController: NavHostController
) {

    val viewModel = viewModel<MoviesViewModel>()

    val onPosterClick = { id: Int ->
        navController.navigate(MovieDetailsScreen(
            movieId = id
        ))
    }

    Column (
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        PosterRailComp(
            posterRailTitle = stringResource(R.string.home_screen_tab_movies_now_playing),
            posterRailData = viewModel.nowPlayingTitles.value,
            onPosterClick = onPosterClick
        )
        PosterRailComp(
            posterRailTitle = stringResource(R.string.home_screen_tab_movies_top_rated),
            posterRailData = viewModel.topRatedTitles.value,
            onPosterClick = onPosterClick
        )
        PosterRailComp(
            posterRailTitle = stringResource(R.string.home_screen_tab_movies_popular),
            posterRailData = viewModel.popularTitles.value,
            onPosterClick = onPosterClick
        )
        PosterRailComp(
            posterRailTitle = stringResource(R.string.home_screen_tab_movies_upcoming),
            posterRailData = viewModel.upcomingTitles.value
        )
    }
}