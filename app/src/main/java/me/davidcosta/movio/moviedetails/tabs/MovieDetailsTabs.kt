package me.davidcosta.movio.moviedetails.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Movie
import me.davidcosta.movio.moviedetails.tabs.overview.OverviewTab
import me.davidcosta.movio.moviedetails.tabs.similar.SimilarTab
import me.davidcosta.movio.moviedetails.tabs.trailers.TrailersTab

enum class MovieDetailsTabs {
    OVERVIEW,
    TRAILERS,
    SIMILAR
}

val MovieDetailsTabs.title: String
    @Composable
    @ReadOnlyComposable
    get() = when (this) {
        MovieDetailsTabs.OVERVIEW -> stringResource(R.string.movie_detail_screen_tab_overview)
        MovieDetailsTabs.TRAILERS -> stringResource(R.string.movie_detail_screen_tab_trailers)
        MovieDetailsTabs.SIMILAR -> stringResource(R.string.movie_detail_screen_tab_related)
    }

@Composable
fun MovieDetailsTabs.Screen(
    navHostController: NavHostController,
    movie: Movie
) =
    when (this) {
        MovieDetailsTabs.OVERVIEW -> OverviewTab(movie = movie, navHostController = navHostController)
        MovieDetailsTabs.TRAILERS -> TrailersTab(navHostController = navHostController)
        MovieDetailsTabs.SIMILAR -> SimilarTab(navHostController = navHostController)
    }