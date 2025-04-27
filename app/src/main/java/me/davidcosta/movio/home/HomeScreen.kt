package me.davidcosta.movio.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import me.davidcosta.movio.core.components.core.tab.MovioTab
import me.davidcosta.movio.core.components.core.tab.MovioTabRow
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.home.tabs.HomeTabs
import me.davidcosta.movio.home.tabs.Screen
import me.davidcosta.movio.home.tabs.title


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()
    var selectedIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { HomeTabs.entries.size }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    LaunchedEffect(pagerState.currentPage) {
        selectedIndex = pagerState.currentPage
    }

    Scaffold(
        topBar = {
            TopBarComp(
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            MovioTabRow(
                selectedIndex = selectedIndex
            ) {
                HomeTabs.entries.forEachIndexed { index, tab ->
                    MovioTab(
                        selected = selectedIndex == index,
                        title = tab.title
                    ) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                }
            }
            HorizontalPager(
                state = pagerState,
            ) { index ->
                HomeTabs
                    .entries[index]
                    .Screen(navController)
                }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@ExperimentalMaterial3Api
@Composable
fun HomePreview() {
    AppTheme(changeSystemBarStyle = false) {
        HomeScreen(rememberNavController())
    }
}