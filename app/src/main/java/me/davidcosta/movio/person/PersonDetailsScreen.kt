package me.davidcosta.movio.person

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import me.davidcosta.movio.R
import me.davidcosta.movio.core.components.core.DSTopBar
import me.davidcosta.movio.core.components.core.tab.DSTab
import me.davidcosta.movio.core.components.core.tab.DSTabRow
import me.davidcosta.movio.core.components.core.tab.DSTabStyle
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.person.tabs.PersonScreenTabs
import me.davidcosta.movio.person.tabs.Screen
import me.davidcosta.movio.person.tabs.title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonDetailsScreen(navHostController: NavHostController) {

    val viewModel = viewModel<PersonDetailsViewModel>()
    val coroutineScope = rememberCoroutineScope()
    var selectedIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { PersonScreenTabs.entries.size }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    LaunchedEffect(pagerState.currentPage) {
        selectedIndex = pagerState.currentPage
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            viewModel.person.value?.let { personCredit ->
                DSTopBar(
                    scrollBehavior = scrollBehavior,
                    expandedHeight = 170.dp,
                    collapsedTitle = personCredit.name,
                    navHostController = navHostController
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = DS.spacing.horizontalMargin),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            modifier = Modifier.size(120.dp)
                        ) {
                            AsyncImage(
                                model = personCredit.profilePath,
                                contentDescription = stringResource(
                                    R.string.person_details_screen_content_description_profile,
                                    personCredit.name
                                ),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Column(
                            modifier = Modifier.padding(
                                start = DS.spacing.medium
                            )
                        ) {
                            Text(
                                style = MaterialTheme.typography.displaySmall,
                                text = personCredit.name
                            )
                            personCredit.birthday?.let {
                                Text(
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.secondary,
                                    text = it
                                )
                            }
                            personCredit.placeOfBirth?.let {
                                Text(
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.secondary,
                                    text = it
                                )
                            }
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        viewModel.person.value?.let { personCredit ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                DSTabRow(
                    selectedIndex = selectedIndex,
                    tabStyle = DSTabStyle.Secondary
                ) {
                    PersonScreenTabs.entries.forEachIndexed { index, tab ->
                        DSTab(
                            title = tab.title,
                            selected = selectedIndex == index
                        ) {
                            selectedIndex = index
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    }
                }
                HorizontalPager(
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxSize(),
                    state = pagerState
                ) { index ->
                    PersonScreenTabs
                        .entries[index]
                        .Screen(
                            navHostController = navHostController,
                            person = personCredit
                        )
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