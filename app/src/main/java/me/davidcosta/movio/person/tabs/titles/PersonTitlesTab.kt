package me.davidcosta.movio.person.tabs.titles

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import me.davidcosta.movio.MovieDetailsScreenRoute
import me.davidcosta.movio.R
import me.davidcosta.movio.TvShowDetailsScreenRoute
import me.davidcosta.movio.core.components.poster.PosterComp
import me.davidcosta.movio.core.domain.MediaType
import me.davidcosta.movio.core.domain.PersonCredit
import me.davidcosta.movio.core.domain.toPoster
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.utils.validate
import me.davidcosta.movio.core.utils.orDefault

@Composable
fun PersonTitlesTab(navHostController: NavHostController) {

    val viewModel = viewModel<PersonTitlesViewModel>()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(viewModel.personCredits.value) { credit ->
            MovieItem(personCredit = credit) {
                navHostController.navigate(
                    when (credit.mediaType) {
                        MediaType.MOVIE -> {
                            MovieDetailsScreenRoute(
                                movieId = credit.id
                            )
                        }
                        MediaType.TV_SHOW -> {
                            TvShowDetailsScreenRoute(
                                tvShowId = credit.id
                            )
                        }
                    }
                )
            }
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
        modifier = Modifier
            .padding(bottom = MaterialTheme.spacing.tiny)
            .fillMaxWidth(),
        onClick = {
            isVisible = isVisible.not()
        }
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
                    .padding(
                        top = MaterialTheme.spacing.medium,
                        bottom = MaterialTheme.spacing.small
                    )
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
                        .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
                        .padding(bottom = MaterialTheme.spacing.medium)
                ) {
                    PosterComp(
                        posterData = personCredit.toPoster(),
                        onPosterClick = { onClick() }
                    )
                    Column {
                        Text(
                            modifier = Modifier.padding(start = MaterialTheme.spacing.medium),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.secondary,
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