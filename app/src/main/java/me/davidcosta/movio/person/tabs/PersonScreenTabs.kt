package me.davidcosta.movio.person.tabs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import me.davidcosta.movio.R
import me.davidcosta.movio.person.tabs.titles.PersonTitlesTab

enum class PersonScreenTabs {
    TITLES,
    OVERVIEW
}

val PersonScreenTabs.title: String
    @Composable
    @ReadOnlyComposable
    get() = when (this) {
        PersonScreenTabs.TITLES -> stringResource(R.string.person_details_screen_tab_titles)
        PersonScreenTabs.OVERVIEW -> stringResource(R.string.person_details_screen_tab_overview)
    }

@Composable
fun PersonScreenTabs.Screen(
    navHostController: NavHostController
) =
    when (this) {
        PersonScreenTabs.TITLES -> PersonTitlesTab(navHostController = navHostController)
        PersonScreenTabs.OVERVIEW -> Text(text = "blah...", modifier = Modifier.fillMaxSize())
    }