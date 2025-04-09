package me.davidcosta.movio.moviedetails.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Movie
import me.davidcosta.movio.core.utils.samples.SampleList
import me.davidcosta.movio.moviedetails.tabs.overview.OverviewTabComp

enum class MovieDetailScreenTabs {
    OVERVIEW,
    TRAILERS,
    RELATED
}

val MovieDetailScreenTabs.title: String
    @Composable
    @ReadOnlyComposable
    get() = when (this) {
        MovieDetailScreenTabs.OVERVIEW -> stringResource(R.string.movie_detail_screen_tab_overview)
        MovieDetailScreenTabs.TRAILERS -> stringResource(R.string.movie_detail_screen_tab_trailers)
        MovieDetailScreenTabs.RELATED -> stringResource(R.string.movie_detail_screen_tab_related)
    }

@Composable
fun MovieDetailScreenTabs.Screen(
    navHostController: NavHostController,
    movie: Movie
) =
    when (this) {
        MovieDetailScreenTabs.OVERVIEW -> OverviewTabComp(movie = movie, navHostController = navHostController)
        MovieDetailScreenTabs.TRAILERS -> SampleList()
        MovieDetailScreenTabs.RELATED -> SampleList()
    }