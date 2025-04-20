package me.davidcosta.movio.movie.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Movie
import me.davidcosta.movio.movie.tabs.overview.OverviewTab
import me.davidcosta.movio.movie.tabs.similar.SimilarTab
import me.davidcosta.movio.movie.tabs.trailers.TrailersTab

enum class MovieTabs {
    OVERVIEW,
    TRAILERS,
    SIMILAR
}

val MovieTabs.title: String
    @Composable
    @ReadOnlyComposable
    get() = when (this) {
        MovieTabs.OVERVIEW -> stringResource(R.string.movie_detail_screen_tab_overview)
        MovieTabs.TRAILERS -> stringResource(R.string.movie_detail_screen_tab_trailers)
        MovieTabs.SIMILAR -> stringResource(R.string.movie_detail_screen_tab_related)
    }

@Composable
fun MovieTabs.Screen(
    navHostController: NavHostController,
    movie: Movie
) =
    when (this) {
        MovieTabs.OVERVIEW -> OverviewTab(movie = movie, navHostController = navHostController)
        MovieTabs.TRAILERS -> TrailersTab(navHostController = navHostController)
        MovieTabs.SIMILAR -> SimilarTab(navHostController = navHostController)
    }