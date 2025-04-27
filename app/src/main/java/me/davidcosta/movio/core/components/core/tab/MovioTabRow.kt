package me.davidcosta.movio.core.components.core.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.davidcosta.movio.core.theme.spacing

@Composable
fun MovioTabRow(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    tabStyle: TabStyle = TabStyle.Primary,
    tabs: @Composable () -> Unit
) {
    val outlineColor = MaterialTheme.colorScheme.outline
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
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
            contentColor = tabStyle.color(),
            divider = {},
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    height = 2.dp,
                    color = tabStyle.color(),
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex])
                )
            },
            tabs = tabs
        )
    }
}



//@Preview
//@Composable
//fun PreviewTabsComp() {
//    AppTheme(changeSystemBarStyle = false) {
//        TabsComp(
//            selectedIndex = 0,
//            onTabSelected = {}
//        )
//    }
//}