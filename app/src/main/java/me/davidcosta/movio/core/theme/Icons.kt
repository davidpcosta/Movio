package me.davidcosta.movio.core.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import me.davidcosta.movio.R

object Icons {
    val Search: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_search)

    val Home: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_home)

    val Arrow: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_arrow)

    val StarRate: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_star_rate)

    val Play: ImageVector
        @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_play)
}
