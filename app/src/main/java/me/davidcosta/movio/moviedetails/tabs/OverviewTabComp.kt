package me.davidcosta.movio.moviedetails.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import me.davidcosta.movio.R
import me.davidcosta.movio.core.components.core.ExpandableText
import me.davidcosta.movio.core.components.core.GenreComp
import me.davidcosta.movio.core.components.person.PersonComp
import me.davidcosta.movio.core.domain.Movie
import me.davidcosta.movio.core.theme.spacing

@Composable
fun OverviewTabComp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    movie: Movie

) {
    val movieCreditsViewModel = viewModel<MovieCreditsViewModel>()

    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(R.string.movie_detail_screen_tab_related_label_overview),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.large)
                    .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
            )
            ExpandableText(
                text = movie.overview,
                style = MaterialTheme.typography.bodyMedium,
//                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.medium)
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
                    GenreComp(text = genre )
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
                    .padding(top = MaterialTheme.spacing.small)
            ) {
                items(movieCreditsViewModel.moviePerson.value) { person ->
                    PersonComp(
                        personData = person
                    )
                }
            }
        }
    }
}