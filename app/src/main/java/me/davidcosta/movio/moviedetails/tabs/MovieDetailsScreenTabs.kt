package me.davidcosta.movio.moviedetails.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Movie
import me.davidcosta.movio.moviedetails.tabs.overview.OverviewTabComp
import me.davidcosta.movio.moviedetails.tabs.similar.SimilarTabComp
import me.davidcosta.movio.moviedetails.tabs.trailers.TrailersTabComp

enum class MovieDetailsScreenTabs {
    OVERVIEW,
    TRAILERS,
    SIMILAR
}

val MovieDetailsScreenTabs.title: String
    @Composable
    @ReadOnlyComposable
    get() = when (this) {
        MovieDetailsScreenTabs.OVERVIEW -> stringResource(R.string.movie_detail_screen_tab_overview)
        MovieDetailsScreenTabs.TRAILERS -> stringResource(R.string.movie_detail_screen_tab_trailers)
        MovieDetailsScreenTabs.SIMILAR -> stringResource(R.string.movie_detail_screen_tab_related)
    }

@Composable
fun MovieDetailsScreenTabs.Screen(
    navHostController: NavHostController,
    movie: Movie
) =
    when (this) {
        MovieDetailsScreenTabs.OVERVIEW -> OverviewTabComp(movie = movie, navHostController = navHostController)
        MovieDetailsScreenTabs.TRAILERS -> TrailersTabComp(navHostController = navHostController)
        MovieDetailsScreenTabs.SIMILAR -> SimilarTabComp(navHostController = navHostController)
    }