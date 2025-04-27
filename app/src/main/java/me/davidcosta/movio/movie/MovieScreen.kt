package me.davidcosta.movio.movie

import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import me.davidcosta.movio.core.components.core.tab.MovioTab
import me.davidcosta.movio.core.components.core.tab.MovioTabRow
import me.davidcosta.movio.core.components.core.tab.TabStyle
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.movie.tabs.MovieTabs
import me.davidcosta.movio.movie.tabs.Screen
import me.davidcosta.movio.movie.tabs.title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(
    navController: NavHostController
) {
    val viewModel = viewModel<MovieViewModel>()
    var selectedIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { MovieTabs.entries.size }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val coroutine = rememberCoroutineScope()

    LaunchedEffect(pagerState.currentPage) {
        selectedIndex = pagerState.currentPage
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBarComp(
                scrollBehavior = scrollBehavior,
                movie = viewModel.movieDetail.value,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            viewModel.movieDetail.value?.let { movie ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    MovioTabRow(
                        selectedIndex = selectedIndex,
                        tabStyle = TabStyle.Secondary
                    ) {
                        MovieTabs.entries.forEachIndexed { index, tab ->
                            MovioTab(
                                selected = selectedIndex == index,
                                title = tab.title
                            ) {
                                coroutine.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }
                        }
                    }
                    HorizontalPager(state = pagerState) { index ->
                        MovieTabs
                            .entries[index]
                            .Screen(
                                navHostController = navController,
                                movie = movie
                            )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AppTheme(changeSystemBarStyle = false) {
        MovieScreen(rememberNavController())
    }
}