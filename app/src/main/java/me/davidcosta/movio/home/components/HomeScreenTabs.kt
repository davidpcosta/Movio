package me.davidcosta.movio.home.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import me.davidcosta.movio.R
import me.davidcosta.movio.core.utils.samples.SampleList
import me.davidcosta.movio.home.tabs.movies.MoviesTabComp
import me.davidcosta.movio.home.tabs.tvshows.TvShowsTabComp

enum class HomeScreenTabs {
    MOVIES,
    TV_SHOWS,
    SERIES,
    ANIME
}

val HomeScreenTabs.title: String
    @Composable
    @ReadOnlyComposable
    get() = when (this) {
        HomeScreenTabs.MOVIES -> stringResource(R.string.home_screen_tab_movies)
        HomeScreenTabs.TV_SHOWS -> stringResource(R.string.home_screen_tab_tv_shows)
        HomeScreenTabs.SERIES -> stringResource(R.string.home_screen_tab_series)
        HomeScreenTabs.ANIME -> stringResource(R.string.home_screen_tab_anime)
    }

@Composable
fun HomeScreenTabs.Screen(
    navController: NavHostController
) =
    when (this) {
        HomeScreenTabs.MOVIES -> MoviesTabComp(navController)
        HomeScreenTabs.TV_SHOWS -> TvShowsTabComp(navController)
        HomeScreenTabs.SERIES -> SampleList()
        HomeScreenTabs.ANIME -> SampleList()
}