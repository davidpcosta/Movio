package me.davidcosta.movio.person.tabs.titles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import me.davidcosta.movio.MovieDetailsScreen
import me.davidcosta.movio.TvShowDetailsScreen
import me.davidcosta.movio.core.domain.MediaType
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.utils.orNotAvailable

@Composable
fun PersonTitlesTab(navHostController: NavHostController) {

    val viewModel = viewModel<PersonTitlesViewModel>()

    LazyColumn {
        items(viewModel.personCredits.value) { credit ->
            Surface(
                modifier = Modifier
                    .padding(bottom = MaterialTheme.spacing.tiny)
                    .fillMaxWidth(),
                onClick = {
                    navHostController.navigate(
                        when (credit.mediaType) {
                            MediaType.MOVIE -> {
                                MovieDetailsScreen(
                                    movieId = credit.id
                                )
                            }
                            MediaType.TV_SHOW -> {
                                TvShowDetailsScreen(
                                    tvShowId = credit.id
                                )
                            }
                        }

                    )
                }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.spacing.horizontalMargin,
                            vertical = MaterialTheme.spacing.medium
                        ),
                ) {
                    Text(
                        style = MaterialTheme.typography.bodyMedium,
                        text = credit.releaseYear.orNotAvailable(),
                        modifier = Modifier.width(50.dp)
                    )
                    Column {
                        Text(
                            style = MaterialTheme.typography.titleLarge,
                            text = credit.title
                        )
                        Text(
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.secondary,
                            text = credit.character
                        )
                    }
                }
            }
        }
    }
}