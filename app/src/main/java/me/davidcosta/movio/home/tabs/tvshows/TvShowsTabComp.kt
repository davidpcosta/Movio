package me.davidcosta.movio.home.tabs.tvshows

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import me.davidcosta.movio.R
import me.davidcosta.movio.core.components.poster.PosterRailComp

@Composable
fun TvShowsTabComp(
    navController: NavHostController
) {

    val viewModel = viewModel<TvShowsViewModel>()

    Column (
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        PosterRailComp(
            posterRailTitle = stringResource(R.string.home_screen_tab_tv_shows_airing_today),
            posterRailData = viewModel.airingTodayTvShows.value
        )
        PosterRailComp(
            posterRailTitle = stringResource(R.string.home_screen_tab_tv_shows_on_the_air),
            posterRailData = viewModel.onTheAirTvShows.value
        )
        PosterRailComp(
            posterRailTitle = stringResource(R.string.home_screen_tab_tv_shows_popular),
            posterRailData = viewModel.popularTvShows.value
        )
        PosterRailComp(
            posterRailTitle = stringResource(R.string.home_screen_tab_tv_shows_top_rated),
            posterRailData = viewModel.topRatedTvShows.value
        )
    }
}