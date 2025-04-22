package me.davidcosta.movio.tvshow.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.TvShow
import me.davidcosta.movio.tvshow.tabs.episodes.TvShowEpisodesTab
import me.davidcosta.movio.tvshow.tabs.overview.TvShowOverviewTab

enum class TvShowTabs {
    EPISODES,
    OVERVIEW
}


val TvShowTabs.title: String
    @Composable
    @ReadOnlyComposable
    get() = when (this) {
        TvShowTabs.EPISODES -> stringResource(R.string.tv_show_tab_episodes)
        TvShowTabs.OVERVIEW -> stringResource(R.string.tv_show_tab_overview)
    }

@Composable
fun TvShowTabs.Screen(
    navHostController: NavHostController,
    tvShow: TvShow
) {
    when (this) {
        TvShowTabs.EPISODES -> TvShowEpisodesTab(tvShow)
        TvShowTabs.OVERVIEW -> TvShowOverviewTab(navHostController, tvShow)
    }
}