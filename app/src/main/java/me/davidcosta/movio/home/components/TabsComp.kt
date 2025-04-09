package me.davidcosta.movio.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
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
    ) {
        ScrollableTabRow(
            selectedTabIndex = selectedIndex,
            containerColor = Color.Transparent,
            divider = {},
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    height = 2.dp,
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedIndex])
                )
            },
            edgePadding = MaterialTheme.spacing.horizontalMargin
        ) {
            HomeScreenTabs.entries.forEachIndexed { index, tab ->
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
fun TabPreview() {
    AppTheme(changeSystemBarStyle = false) {
        TabsComp(
            selectedIndex = 0
        )
    }
}