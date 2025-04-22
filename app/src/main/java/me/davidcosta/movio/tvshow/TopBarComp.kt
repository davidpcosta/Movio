package me.davidcosta.movio.tvshow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.davidcosta.movio.R
import me.davidcosta.movio.core.components.core.DotSeparatorComp
import me.davidcosta.movio.core.domain.TvShow
import me.davidcosta.movio.core.theme.Icons
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.utils.orDefault

@ExperimentalMaterial3Api
@Composable
fun TopBarComp(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    tvShow: TvShow?
) {
    TopAppBar(
        title = {
            tvShow?.let {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                        .padding(end = 12.dp)
                ) {
                    Surface(
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier
                            .padding(top = MaterialTheme.spacing.large)
                    )  {
                        AsyncImage(
                            model = tvShow.posterPath,
                            contentScale = ContentScale.Crop,
                            contentDescription = stringResource(
                                R.string.poster_content_description_image,
                                tvShow.name
                            ),
                            modifier = Modifier
                                .width(dimensionResource(R.dimen.movie_detail_poster_width))
                                .height(dimensionResource(R.dimen.movie_detail_poster_height))
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(top = MaterialTheme.spacing.small)
                    ) {
                        Text(
                            text = tvShow.firstAirYear.orDefault("-"),
                            style = MaterialTheme.typography.titleMedium
                        )
                        DotSeparatorComp(
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.small)
                        )
                        Text(
                            text = pluralStringResource(
                                R.plurals.tv_show_label_seasons,
                                tvShow.seasonsCount,
                                tvShow.seasonsCount
                            ),
                            style = MaterialTheme.typography.titleMedium
                        )
                        DotSeparatorComp(
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.small)
                        )
                        Icon(
                            imageVector = Icons.StarRate,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = stringResource(R.string.movie_detail_screen_content_description_icon_rate),
                            modifier = Modifier
                                .size(dimensionResource(R.dimen.movie_detail_icon_rate_size))
                                .padding(end = MaterialTheme.spacing.small)
                        )
                        Text(
                            text = tvShow.voteAverage,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        },
        scrollBehavior = scrollBehavior,
        expandedHeight = 360.dp,
        colors = TopAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color.Transparent,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            actionIconContentColor = MaterialTheme.colorScheme.onBackground
        ),
        modifier = modifier
            .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
    )
}