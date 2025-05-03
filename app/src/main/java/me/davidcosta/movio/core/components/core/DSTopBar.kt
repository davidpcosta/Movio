package me.davidcosta.movio.core.components.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.davidcosta.movio.R
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.color
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSTopBar(
    collapsedTitle: String,
    expandedHeight: Dp = 320.dp,
    scrollBehavior: TopAppBarScrollBehavior,
    navHostController: NavHostController,
    content: @Composable () -> Unit
) {
    LargeTopAppBar(
        title = {
            val collapsedFraction = scrollBehavior.state.collapsedFraction
            if (collapsedFraction < 0.6f) {
                content()
            } else {
                Text(
                    style = DS.typography.displaySmall,
                    text = collapsedTitle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                        .padding(end = DS.spacing.horizontalMargin)
                )
            }
        },
        scrollBehavior = scrollBehavior,
        expandedHeight = expandedHeight,
        collapsedHeight = 40.dp,
        navigationIcon = {
            IconButton(
                onClick = { navHostController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.app_toolbar_content_description_icon_back)
                )
            }
        },
        colors = TopAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color.Transparent,
            navigationIconContentColor = DS.color.onBackground,
            titleContentColor = DS.color.onBackground,
            actionIconContentColor = DS.color.onBackground
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewDSTopBar() {
    AppTheme(changeSystemBarStyle = false) {
        DSTopBar(
            collapsedTitle = "Colapsed title",
            scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
            navHostController = rememberNavController()
        ) {
            Box(
                Modifier.fillMaxSize()
                    .background(Color.Gray)
            )
        }
    }
}