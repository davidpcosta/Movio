package me.davidcosta.movio.tvshow.tabs.episodes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun TvShowEpisodesTab(
    navHostController: NavHostController
) {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = "Episodes"
    )
}