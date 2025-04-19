package me.davidcosta.movio.person.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.moviedetails.tabs.MovieDetailsScreenTabs
import me.davidcosta.movio.moviedetails.tabs.title

@Composable
fun TabsComp(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    onClick: (Int) -> Unit = {}
) {
    val outlineColor = MaterialTheme.colorScheme.outline
    Box(
        modifier = modifier
            .drawBehind {
                val borderSize = 2.dp.toPx()
                val y = size.height - borderSize / 2
                drawLine(
                    color = outlineColor,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, y),
                    strokeWidth = borderSize
                )
            }
            .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
    ) {
        TabRow(
            selectedTabIndex = selectedIndex,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            divider = {},
            indicator = { tabPositions ->
                TabRowDefaults.PrimaryIndicator(
                    height = 2.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedIndex])
                )
                TabRowDefaults.SecondaryIndicator(
                    height = 2.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedIndex])
                )
            }
        ) {
            PersonScreenTabs.entries.forEachIndexed { index, tab ->
                val style = if (tab.ordinal == selectedIndex) {
                    MaterialTheme.typography.headlineMedium
                } else {
                    MaterialTheme.typography.bodyMedium
                }

                Tab(
                    text = {
                        Text(
                            text = tab.title,
                            style = style
                        )
                    },
                    selected =  selectedIndex == index,
                    unselectedContentColor = MaterialTheme.colorScheme.onBackground,
                    onClick = {
                        onClick(index)
                    }
                )

            }
        }
    }
}

@Preview
@Composable
fun PreviewTabsComp() {
    AppTheme(changeSystemBarStyle = false) {
        TabsComp(
            selectedIndex = 0,
            onClick = {}
        )
    }
}