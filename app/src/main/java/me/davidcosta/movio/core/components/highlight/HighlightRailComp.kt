package me.davidcosta.movio.core.components.highlight

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.davidcosta.movio.core.domain.Title
import me.davidcosta.movio.core.utils.samples.SampleData
import me.davidcosta.movio.core.utils.samples.TitleList
import me.davidcosta.movio.core.theme.AppTheme
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
            pageSpacing = MaterialTheme.spacing.small,
            contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.horizontalMargin)
        ) { page ->
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                HighlightComp(
                    titleData = railHighlightData[page]
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
            railHighlightData = SampleData.TitleList
        )
    }
}