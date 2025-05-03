package me.davidcosta.movio.core.components.highlight

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.davidcosta.movio.core.domain.Title
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.spacing

@Composable
fun HighlightRailComp(
    modifier: Modifier = Modifier,
    railHighlightData: List<Title>
) {
    val pagerState = rememberPagerState { railHighlightData.size }
    Box(
        modifier = modifier
    ) {
        HorizontalPager(
            state = pagerState,
            pageSpacing = DS.spacing.small,
            contentPadding = PaddingValues(horizontal = DS.spacing.horizontalMargin)
        ) { page ->
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                DSHighlight(
                    highlightData = railHighlightData[page]
                )
            }

        }
    }
}

@Preview
@Composable
fun PreviewRailHighlightComp() {
    AppTheme(changeSystemBarStyle = false) {
        HighlightRailComp(
            railHighlightData = (1..3).map { i ->
                Title(
                    title = "Filme $i",
                    posterPath = "ponster.jpg",
                    thumbPath = "thumb.jpg",
                    voteAverage = "8,9",
                    releaseYear = "2025"
                )
            }
        )
    }
}