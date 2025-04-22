package me.davidcosta.movio.movie.tabs.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.davidcosta.movio.PersonDetailsScreenRoute
import me.davidcosta.movio.R
import me.davidcosta.movio.core.components.core.GenreComp
import me.davidcosta.movio.core.components.person.PersonComp
import me.davidcosta.movio.core.domain.Movie
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.utils.orDefault

@Composable
fun MovieOverviewTab(
    navHostController: NavHostController,
    movie: Movie
) {
    val movieOverviewViewModel = viewModel<MovieOverviewViewModel>()

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.large)
                .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(R.string.movie_detail_screen_tab_overview_label_title),
                    style = MaterialTheme.typography.headlineLarge,
                )
                Text(
                    modifier = Modifier.padding(top = MaterialTheme.spacing.small),
                    text = movie.title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(R.string.movie_detail_screen_tab_overview_label_original_title),
                    style = MaterialTheme.typography.headlineLarge,
                )
                Text(
                    modifier = Modifier.padding(top = MaterialTheme.spacing.small),
                    text = movie.originalTitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
        Text(
            text = stringResource(R.string.movie_detail_screen_tab_related_label_overview),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.large)
                .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
        )
        Text(
            text = movie.overview.orDefault(stringResource(R.string.common_label_overview_unavailable)),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.small)
                .padding(horizontal = MaterialTheme.spacing.horizontalMargin),
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.spacing.horizontalMargin
            ),
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.medium)
        ) {
            items(movie.genres) { genre ->
                GenreComp(text = genre)
            }
        }
        Text(
            text = stringResource(R.string.movie_detail_screen_tab_related_label_cast_and_crew),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.large)
                .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.spacing.horizontalMargin
            ),
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.medium)
        ) {
            items(movieOverviewViewModel.movieCharacter.value) { person ->
                PersonComp(
                    characterData = person,
                    onClick = {
                        navHostController.navigate(PersonDetailsScreenRoute(
                            personId = person.id
                        ))
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewOverviewTab() {
    AppTheme(changeSystemBarStyle = false) {
        MovieOverviewTab(
            navHostController = rememberNavController(),
            movie = Movie(
                title = "Adolescencia",
                originalTitle = "Adolescense",
                posterPath = "poster.jpg",
                releaseYear = "2025",
                overview = "A fada fala alfafa.",
                runtime = "2h25m",
                voteAverage = "8,5",
                genres = listOf("Drama", "Açãio")
            )
        )
    }
}