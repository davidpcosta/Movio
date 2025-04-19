package me.davidcosta.movio.person

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.person.tabs.PersonScreenTabs
import me.davidcosta.movio.person.tabs.Screen
import me.davidcosta.movio.person.tabs.TabsComp

@Composable
fun PersonDetailsScreen(navHostController: NavHostController) {

    val viewModel = viewModel<PersonDetailsViewModel>()
    val coroutineScope = rememberCoroutineScope()
    var selectedIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { PersonScreenTabs.entries.size }

    LaunchedEffect(pagerState.currentPage) {
        selectedIndex = pagerState.currentPage
    }

    Scaffold { innerPadding ->

        viewModel.person.value?.also { person ->
            Column(
                modifier = Modifier.padding(innerPadding)
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier.padding(
                        horizontal = MaterialTheme.spacing.horizontalMargin,
                        vertical = MaterialTheme.spacing.large
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = CircleShape,
                        modifier = Modifier.size(120.dp)
                    ) {
                        AsyncImage(
                            model = person.profilePath,
                            contentDescription = "Movie poster",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Column(
                        modifier = Modifier.padding(
                            start = MaterialTheme.spacing.medium
                        )
                    ) {
                        Text(
                            style = MaterialTheme.typography.displaySmall,
                            text = person.name
                        )
                        person.birthday?.let {
                            Text(
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.secondary,
                                text = it
                            )
                        }
                        Text(
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.secondary,
                            text = person.placeOfBirth
                        )
                    }
                }

                TabsComp(
                    selectedIndex = selectedIndex,
                    onClick = { index ->
                        selectedIndex = index
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
                HorizontalPager(
                    state = pagerState,
                ) { index ->
                    Box(
                        modifier = Modifier
                    ) {
                        PersonScreenTabs
                            .entries[index]
                            .Screen(
                                navHostController = navHostController
                            )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPersonDetailsScreen() {
    AppTheme(changeSystemBarStyle = false) {
        PersonDetailsScreen(
            navHostController = rememberNavController()
        )
    }
}