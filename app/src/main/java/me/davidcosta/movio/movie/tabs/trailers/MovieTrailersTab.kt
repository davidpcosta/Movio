package me.davidcosta.movio.movie.tabs.trailers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import me.davidcosta.movio.core.components.DSVideo
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.spacing

@Composable
fun MovieTrailersTab(
    navHostController: NavHostController
) {
    val movieTrailersViewModel = viewModel<MovieTrailersViewModel>()
    val uriHandler = LocalUriHandler.current

    val goToVideo: (String) -> Unit = { videoPath ->
        uriHandler.openUri(videoPath)
    }

    LazyColumn(
        contentPadding = PaddingValues(
            horizontal = DS.spacing.horizontalMargin,
            vertical = DS.spacing.large
        ),
        verticalArrangement = Arrangement.spacedBy(DS.spacing.medium),
        modifier = Modifier.fillMaxSize()
    ) {
        items(movieTrailersViewModel.movieVideos.value) { video ->
            DSVideo(
                thumbData = video,
                onClick = { videoPath ->
                    goToVideo(videoPath)
                }
            )
        }
    }
}