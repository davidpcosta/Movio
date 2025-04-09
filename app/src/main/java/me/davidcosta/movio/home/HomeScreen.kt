package me.davidcosta.movio.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
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
import me.davidcosta.movio.home.components.TabsComp
import me.davidcosta.movio.home.components.TopBarComp
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.home.components.HomeScreenTabs
import me.davidcosta.movio.home.components.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()
    var selectedIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { HomeScreenTabs.entries.size }
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
            TabsComp(selectedIndex = selectedIndex) { index ->
                selectedIndex = index
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }
            TabContent(
                pagerState = pagerState,
                navController = navController
            )
        }
    }
}

@Composable
private fun TabContent(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    navController: NavHostController
    ) {
    HorizontalPager(
        state = pagerState,
    ) { index ->
        Box(
            modifier = modifier
        ) {
            HomeScreenTabs
                .entries[index]
                .Screen(navController)
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