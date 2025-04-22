package me.davidcosta.movio.tvshow.tabs.episodes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Season
import me.davidcosta.movio.core.domain.TvShow
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.utils.orDefault

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowEpisodesTab(
    tvShow: TvShow
) {
    val episodesViewModel = viewModel<TvShowEpisodesViewModel>()
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedSeason by remember { mutableStateOf(tvShow.seasons.first{ it.seasonNumber == 1}) }

    episodesViewModel.fetchTvShowEpisodes(
        tvShowId = tvShow.id,
        seasonNumber = selectedSeason.seasonNumber
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.tiny)
        ) {
            item {
                Button(
                    modifier = Modifier
                        .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
                        .padding(top = MaterialTheme.spacing.small),
                    onClick = {
                        showBottomSheet = true
                    }
                ) {
                    Text(text = selectedSeason.name)
                }
            }
            items(episodesViewModel.episodes.value) { episode ->
                var isVisible by remember { mutableStateOf(false) }
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        isVisible = isVisible.not()
                    }
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
                                .padding(vertical = MaterialTheme.spacing.small)
                        ) {
                            Surface(
                                shape = MaterialTheme.shapes.small,
                                modifier = Modifier
                                    .width(150.dp).height(84.dp)
                                    .padding(end = MaterialTheme.spacing.medium)
                            ) {
                                AsyncImage(
                                    model = episode.stillPath,
                                    contentScale = ContentScale.Crop,
                                    contentDescription = stringResource(
                                        R.string.poster_content_description_image,
                                        episode.name
                                    ),
                                    modifier = Modifier
                                        .fillMaxSize()
                                )
                            }
                            Column {
                                Text(
                                    style = MaterialTheme.typography.titleSmall,
                                    text = "${episode.episodeNumber}. ${episode.name}"
                                )
                                episode.airDate?.let {
                                    Text(
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.secondary,
                                        text = it
                                    )
                                }
                                episode.runtime?.let {
                                    Text(
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.secondary,
                                        text = it
                                    )
                                }
                            }
                        }
                        AnimatedVisibility(visible = isVisible) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
                                    .padding(bottom = MaterialTheme.spacing.small)
                            ) {
                                Text(
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.secondary,
                                    text = episode.overview.orDefault(stringResource(R.string.common_label_overview_unavailable)),
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = bottomSheetState
        ) {
            val selectSeason = { season: Season ->
                coroutineScope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                    if (bottomSheetState.isVisible.not()) {
                        episodesViewModel.fetchTvShowEpisodes(
                            tvShowId = tvShow.id,
                            seasonNumber = season.seasonNumber
                        )
                        selectedSeason = season
                        showBottomSheet = false
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = MaterialTheme.spacing.medium)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(tvShow.seasons) { season ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.clickable {
                                selectSeason(season)
                            }
                        ) {
                            RadioButton(
                                selected = season.id == selectedSeason.id,
                                onClick = {
                                    selectSeason(season)
                                }
                            )
                            Text(
                                text = season.name,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(
                                        horizontal = MaterialTheme.spacing.horizontalMargin,
                                        vertical = MaterialTheme.spacing.small
                                    )
                            )
                        }
                    }
                }
            }
        }
    }

}