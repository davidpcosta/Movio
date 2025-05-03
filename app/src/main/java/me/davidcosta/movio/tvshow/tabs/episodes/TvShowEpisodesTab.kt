package me.davidcosta.movio.tvshow.tabs.episodes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.davidcosta.movio.R
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.color
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.theme.typography
import me.davidcosta.movio.core.utils.orDefault

@Composable
fun TvShowEpisodesTab(
    tvShowId: Int,
    seasonNumber: Int
) {
    val episodesViewModel = TvShowEpisodesViewModel(
        tvShowId = tvShowId,
        seasonNumber = seasonNumber
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(DS.spacing.tiny)
        ) {
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
                                .padding(horizontal = DS.spacing.horizontalMargin)
                                .padding(vertical = DS.spacing.small)
                        ) {
                            Surface(
                                shape = MaterialTheme.shapes.small,
                                modifier = Modifier
                                    .width(150.dp).height(84.dp)
                                    .padding(end = DS.spacing.medium)
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
                                    style = DS.typography.titleSmall,
                                    text = "${episode.episodeNumber}. ${episode.name}"
                                )
                                episode.airDate?.let {
                                    Text(
                                        style = DS.typography.bodySmall,
                                        color = DS.color.secondary,
                                        text = it
                                    )
                                }
                                episode.runtime?.let {
                                    Text(
                                        style = DS.typography.bodySmall,
                                        color = DS.color.secondary,
                                        text = it
                                    )
                                }
                            }
                        }
                        AnimatedVisibility(visible = isVisible) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = DS.spacing.horizontalMargin)
                                    .padding(bottom = DS.spacing.small)
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
}