package me.davidcosta.movio.core.components.poster

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Poster
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.Icons
import me.davidcosta.movio.core.theme.spacing

@Composable
fun DSPosterRail(
    modifier: Modifier = Modifier,
    posterRailTitle: String,
    posterRailData: List<Poster>,
    posterSize: PosterSize = PosterSize.Small,
    onPosterClick: (Int) -> Unit = {},
    onSeeMoreClick: (() -> Unit)? = null
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = MaterialTheme.spacing.small)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
                .padding(bottom = MaterialTheme.spacing.small)
                .fillMaxWidth()
        ) {
            Text(
                text = posterRailTitle,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.weight(1f)
            )
            onSeeMoreClick?.let {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .wrapContentWidth()
                        .clickable { it() }
                )  {
                    Text(
                        text = stringResource(R.string.poster_rail_label_more),
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .padding(start = MaterialTheme.spacing.tiny)
                    )
                    Icon(
                        imageVector = Icons.Arrow,
                        contentDescription = stringResource(R.string.poster_rail_content_description_icon_more),
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .padding(all = MaterialTheme.spacing.tiny)
                            .size(dimensionResource(R.dimen.icon_see_more_size))
                    )
                }
            }
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
                contentPadding = PaddingValues(
                    horizontal = MaterialTheme.spacing.horizontalMargin
                ),
                modifier = Modifier.height(posterSize.height)
            ) {
                items(posterRailData) { poster ->
                    DSPoster(
                        posterData = poster,
                        onPosterClick = { id ->
                            onPosterClick(id)
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPosterRailComp() {
    AppTheme (changeSystemBarStyle = false) {
        DSPosterRail(
            posterRailTitle = "A fada fala alfafa",
            posterRailData = listOf(
                Poster(
                    id = 1,
                    title = "Adolescense",
                    posterPath = "poster.jpg"
                )
            )
        )
    }
}