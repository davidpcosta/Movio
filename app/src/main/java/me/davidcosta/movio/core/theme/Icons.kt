package me.davidcosta.movio.core.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import me.davidcosta.movio.R

object Icons

val Icons.Search: ImageVector
    @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_search)

val Icons.Home: ImageVector
    @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_home)

val Icons.Arrow: ImageVector
    @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_arrow)

val Icons.StarRate: ImageVector
    @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_star_rate)

val Icons.Play: ImageVector
    @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_play)