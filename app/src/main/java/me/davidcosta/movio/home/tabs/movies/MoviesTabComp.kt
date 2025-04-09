package me.davidcosta.movio.home.tabs.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import me.davidcosta.movio.MovieDetailScreen
import me.davidcosta.movio.core.components.poster.PosterRailComp
import me.davidcosta.movio.core.components.highlight.HighlightRailComp
import me.davidcosta.movio.core.utils.samples.SampleData
import me.davidcosta.movio.core.utils.samples.TitleList
import me.davidcosta.movio.core.theme.spacing

@Composable
fun MoviesTabComp(
    navController: NavHostController
) {

    val viewModel = viewModel<MoviesTabViewModel>()

    val onPosterClick = { id: Long ->
        navController.navigate(MovieDetailScreen(
            movieId = id
        ))
    }

    Column (
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        HighlightRailComp(
            railHighlightData = SampleData.TitleList,
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.large)
        )
        PosterRailComp(
            posterRailTitle = "Em cartaz",
            posterRailData = viewModel.nowPlayingTitles.value,
            onPosterClick = onPosterClick
        )
        PosterRailComp(
            posterRailTitle = "Melhores notas",
            posterRailData = viewModel.topRatedTitles.value,
            onPosterClick = onPosterClick
        )
        PosterRailComp(
            posterRailTitle = "Populares",
            posterRailData = viewModel.popularTitles.value,
            onPosterClick = onPosterClick
        )
        PosterRailComp(
            posterRailTitle = "Próximos lançamentos",
            posterRailData = viewModel.upcomingTitles.value
        )
    }
}