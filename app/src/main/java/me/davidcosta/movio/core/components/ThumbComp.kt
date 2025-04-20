package me.davidcosta.movio.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Video
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.Icons
import me.davidcosta.movio.core.theme.spacing

@Composable
fun ThumbComp(
    modifier: Modifier = Modifier,
    thumbData: Video,
    onClick: (String) -> Unit = {}
) {
    val width = dimensionResource(R.dimen.highlight_width)
    val height = dimensionResource(R.dimen.highlight_height)

    Box(
        modifier = modifier
    ) {
        Surface(
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            modifier = Modifier
                .width(width)
                .height(height)
        ) {
            AsyncImage(
                model = thumbData.thumbPath,
                contentDescription = thumbData.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClick(thumbData.videoPath)
                    }
            )
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxSize()
                    .background(gradient())
            ) {
                Icon(
                    imageVector = Icons.Play,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                        .size(40.dp)
                        .align(Alignment.Center)
                )
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.medium)
                        .fillMaxSize()
                ) {
                    Text(
                        text = thumbData.name,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        modifier = Modifier.padding(top = MaterialTheme.spacing.tiny)
                    )
                    Text(
                        text = thumbData.publishedAt.orEmpty(),
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = MaterialTheme.spacing.tiny)
                    )
                }
            }
        }
    }
}

@Composable
private fun gradient(): Brush {
    return Brush.linearGradient(
        colors = listOf(Color.Transparent, Color.Transparent, Color.Black),
        start = Offset.Zero,
        end =  Offset(0f, Float.POSITIVE_INFINITY)
    )
}


@Preview
@Composable
fun PreviewThumbComp() {
    AppTheme(changeSystemBarStyle = false) {
        ThumbComp(
            thumbData = Video(
                id = "001",
                thumbPath = "path",
                name = "Filme de teste",
                videoPath = "path",
                publishedAt = "01 de abril de 2025"
            )
        )
    }
}