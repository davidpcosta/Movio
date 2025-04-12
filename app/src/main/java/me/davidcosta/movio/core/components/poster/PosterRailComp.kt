package me.davidcosta.movio.core.components.poster

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Poster
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.Arrow
import me.davidcosta.movio.core.theme.Icons
import me.davidcosta.movio.core.theme.spacing

@Composable
fun PosterRailComp(
    modifier: Modifier = Modifier,
    posterRailTitle: String,
    posterRailData: List<Poster>,
    posterSize: PosterSize = PosterSize.Small,
    onPosterClick: (Int) -> Unit = {}
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(
                    horizontal = MaterialTheme.spacing.horizontalMargin
                )
                .padding(
                    top = MaterialTheme.spacing.medium,
                    bottom = MaterialTheme.spacing.small
                )
                .fillMaxWidth()
        ) {
            Text(
                text = posterRailTitle,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.weight(1f)
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .wrapContentWidth()
            )  {
                Text(
                    text = "Mais",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(start = MaterialTheme.spacing.tiny)
                )
                Icon(
                    imageVector = Icons.Arrow,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(all = MaterialTheme.spacing.tiny)
                        .size(dimensionResource(R.dimen.icon_see_more_size))
                )
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
                    PosterComp(
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
        PosterRailComp(
            posterRailTitle = "A fada fala alfafa",
            posterRailData = listOf(
                Poster(
                    id = 1,
                    title = "Adolescense",
                    posterPath = "poster.jpg",
                    voteAverage = "8,9",
                    releaseYear = "2025"
                )
            )
        )
    }
}