package me.davidcosta.movio.person.tabs.titles

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.davidcosta.movio.MovieScreenRoute
import me.davidcosta.movio.R
import me.davidcosta.movio.TvShowScreenRoute
import me.davidcosta.movio.core.components.poster.DSPoster
import me.davidcosta.movio.core.domain.MediaType
import me.davidcosta.movio.core.domain.PersonCredit
import me.davidcosta.movio.core.domain.toPoster
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.color
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.theme.typography
import me.davidcosta.movio.core.utils.validate
import me.davidcosta.movio.core.utils.orDefault

@Composable
fun PersonTitlesTab(navHostController: NavHostController) {

    val viewModel = viewModel<PersonTitlesViewModel>()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        items(viewModel.personCredits.value) { credit ->
            MovieItem(personCredit = credit) {
                navHostController.navigate(
                    when (credit.mediaType) {
                        MediaType.MOVIE -> {
                            MovieScreenRoute(
                                movieId = credit.id
                            )
                        }
                        MediaType.TV_SHOW -> {
                            TvShowScreenRoute(
                                tvShowId = credit.id
                            )
                        }
                    }
                )
            }
            Spacer(Modifier.height(DS.spacing.tiny))
        }
    }
}

@Composable
private fun MovieItem(
    personCredit: PersonCredit,
    onClick: () -> Unit
) {
    var isVisible by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            isVisible = isVisible.not()
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = DS.spacing.horizontalMargin)
                    .padding(vertical = DS.spacing.small)
                    .heightIn(min = 40.dp)
            ) {
                Text(
                    style = MaterialTheme.typography.bodyMedium,
                    text = personCredit.releaseYear.orDefault(stringResource(R.string.common_label_not_available_short)),
                    modifier = Modifier.width(50.dp)
                )
                Column {
                    Text(
                        style = MaterialTheme.typography.titleLarge,
                        text = personCredit.title
                    )
                    personCredit.character?.validate()?.let {
                        Text(
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.secondary,
                            text = stringResource(
                                R.string.person_details_screen_tab_titles_as_character,
                                personCredit.character
                            )
                        )
                    }
                }
            }
            AnimatedVisibility(visible = isVisible) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = DS.spacing.horizontalMargin)
                        .padding(bottom = DS.spacing.medium)
                ) {
                    DSPoster(
                        posterData = personCredit.toPoster(),
                        onPosterClick = { onClick() }
                    )
                    Column {
                        Text(
                            modifier = Modifier.padding(start = DS.spacing.medium),
                            style = DS.typography.bodyMedium,
                            color = DS.color.secondary,
                            text = personCredit.overview.orDefault(stringResource(R.string.common_label_overview_unavailable)),
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPersonTitlesTab() {
    AppTheme(changeSystemBarStyle = false) {
        PersonTitlesTab(rememberNavController())
    }
}