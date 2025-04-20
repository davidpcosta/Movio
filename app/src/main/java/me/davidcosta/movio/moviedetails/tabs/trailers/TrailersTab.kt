package me.davidcosta.movio.moviedetails.tabs.trailers

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
import me.davidcosta.movio.core.components.ThumbComp
import me.davidcosta.movio.core.theme.spacing

@Composable
fun TrailersTab(
    navHostController: NavHostController
) {
    val trailersViewModel = viewModel<TrailersViewModel>()
    val uriHandler = LocalUriHandler.current

    val goToVideo: (String) -> Unit = { videoPath ->
        uriHandler.openUri(videoPath)
    }

    LazyColumn(
        contentPadding = PaddingValues(
            horizontal = MaterialTheme.spacing.horizontalMargin,
            vertical = MaterialTheme.spacing.large
        ),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
        modifier = Modifier.fillMaxSize()
    ) {
        items(trailersViewModel.movieVideos.value) { video ->
            ThumbComp(
                thumbData = video,
                onClick = { videoPath ->
                    goToVideo(videoPath)
                }
            )
        }
    }
}