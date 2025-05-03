package me.davidcosta.movio.tvshow.tabs.overview

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import me.davidcosta.movio.PersonDetailsScreenRoute
import me.davidcosta.movio.R
import me.davidcosta.movio.core.components.core.DSGenre
import me.davidcosta.movio.core.components.person.DSPerson
import me.davidcosta.movio.core.domain.TvShow
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.color
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.theme.typography
import me.davidcosta.movio.core.utils.orDefault

@Composable
fun TvShowOverviewTab(
    navHostController: NavHostController,
    tvShow: TvShow
) {
    val overviewViewModel = viewModel<TvShowOverviewViewModel>()

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(top = DS.spacing.large)
                .padding(horizontal = DS.spacing.horizontalMargin)
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
                    modifier = Modifier.padding(top = DS.spacing.small),
                    text = tvShow.name,
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
                    modifier = Modifier.padding(top = DS.spacing.small),
                    text = tvShow.originalName,
                    style = DS.typography.bodyMedium,
                    color = DS.color.secondary
                )
            }
        }
        Text(
            text = stringResource(R.string.movie_detail_screen_tab_related_label_overview),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(top = DS.spacing.large)
                .padding(horizontal = DS.spacing.horizontalMargin)
        )
        Text(
            text = tvShow.overview.orDefault(stringResource(R.string.common_label_overview_unavailable)),
            style = DS.typography.bodyMedium,
            color = DS.color.secondary,
            modifier = Modifier
                .padding(top = DS.spacing.small)
                .padding(horizontal = DS.spacing.horizontalMargin),
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(DS.spacing.small),
            contentPadding = PaddingValues(
                horizontal = DS.spacing.horizontalMargin
            ),
            modifier = Modifier
                .padding(top = DS.spacing.medium)
        ) {
            items(tvShow.genres) { genre ->
                DSGenre(text = genre)
            }
        }
        Text(
            text = stringResource(R.string.movie_detail_screen_tab_related_label_cast_and_crew),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(top = DS.spacing.large)
                .padding(horizontal = DS.spacing.horizontalMargin)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(DS.spacing.small),
            contentPadding = PaddingValues(
                horizontal = DS.spacing.horizontalMargin
            ),
            modifier = Modifier
                .padding(top = DS.spacing.medium)
        ) {
            items(overviewViewModel.tvShowCharacter.value) { person ->
                DSPerson(
                    characterData = person,
                    onClick = {
                        navHostController.navigate(
                            PersonDetailsScreenRoute(
                            personId = person.id
                        )
                        )
                    }
                )
            }
        }
    }
}