package me.davidcosta.movio.core.components.core.tab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.color

@Composable
fun DSTabRow(
    selectedIndex: Int,
    tabStyle: DSTabStyle = DSTabStyle.Primary,
    edgePadding: Dp = 0.dp,
    tabs: @Composable () -> Unit
) {
    Box(Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = selectedIndex,
            containerColor = Color.Transparent,
            contentColor = tabStyle.color(),
            divider = {},
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    height = 2.dp,
                    color = tabStyle.color(),
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex])
                )
            },
            modifier = Modifier.padding(horizontal = edgePadding),
            tabs = tabs
        )
        HorizontalDivider(
            color = DS.color.outline,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
fun PreviewDSTabRow() {
    AppTheme(changeSystemBarStyle = false) {
        DSTabRow(
            selectedIndex = 0,
            edgePadding = 16.dp,
            tabStyle = DSTabStyle.Primary
        ) {
            (0..2).map { i ->
                DSTab(
                    title = "Tab $i",
                    selected = i == 0,
                    onClick = {}
                )
            }
        }
    }
}