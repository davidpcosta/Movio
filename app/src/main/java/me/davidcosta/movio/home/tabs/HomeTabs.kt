package me.davidcosta.movio.home.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import me.davidcosta.movio.R
import me.davidcosta.movio.home.tabs.movies.MoviesTab
import me.davidcosta.movio.home.tabs.tvshows.TvShowsTab

enum class HomeTabs {
    MOVIES,
    TV_SHOWS
}

val HomeTabs.title: String
    @Composable
    @ReadOnlyComposable
    get() = when (this) {
        HomeTabs.MOVIES -> stringResource(R.string.home_screen_tab_movies)
        HomeTabs.TV_SHOWS -> stringResource(R.string.home_screen_tab_tv_shows)
    }

@Composable
fun HomeTabs.Screen(
    navController: NavHostController
) =
    when (this) {
        HomeTabs.MOVIES -> MoviesTab(navController)
        HomeTabs.TV_SHOWS -> TvShowsTab(navController)
}