package me.davidcosta.movio.moviedetails

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
import me.davidcosta.movio.moviedetails.tabs.TabsComp
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.moviedetails.tabs.MovieDetailsTabs
import me.davidcosta.movio.moviedetails.tabs.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    navController: NavHostController
) {
    val coroutineScope = rememberCoroutineScope()
    val viewModel = viewModel<MovieDetailsViewModel>()
    var selectedIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { MovieDetailsTabs.entries.size }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    LaunchedEffect(pagerState.currentPage) {
        selectedIndex = pagerState.currentPage
    }

    Scaffold(
        topBar = {
            TopBarComp(
                scrollBehavior = scrollBehavior,
                movie = viewModel.movieDetail.value
            )
        },
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            viewModel.movieDetail.value?.let { movie ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    TabsComp(
                        selectedIndex = selectedIndex,
                        modifier = Modifier
                    ) { index ->
                        selectedIndex = index
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                    HorizontalPager(
                        state = pagerState,
                    ) { index ->
                        Box(
                            modifier = Modifier
                        ) {
                            MovieDetailsTabs
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
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AppTheme(changeSystemBarStyle = false) {
        MovieDetailsScreen(rememberNavController())
    }
}