package me.davidcosta.movio.core.components.core

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.davidcosta.movio.R
import me.davidcosta.movio.core.theme.spacing

@SuppressLint("UnusedBoxWithConstraintsScope")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSTopBar(
    expandedTitle: @Composable () -> Unit,
    collapsedTitle: String,
    expandedHeight: Dp = 320.dp,
    scrollBehavior: TopAppBarScrollBehavior,
    navigateBack: () -> Unit
) {
    LargeTopAppBar(
        title = {
            val collapsedFraction = scrollBehavior.state.collapsedFraction
            if (collapsedFraction < 0.6f) {
                expandedTitle()
            } else {
                Text(
                    style = MaterialTheme.typography.displaySmall,
                    text = collapsedTitle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                        .padding(end = MaterialTheme.spacing.horizontalMargin)
                )
            }
        },
        scrollBehavior = scrollBehavior,
        expandedHeight = expandedHeight,
        collapsedHeight = 40.dp,
        navigationIcon = {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.app_toolbar_content_description_icon_back)
                )
            }
        },
        colors = TopAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color.Transparent,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            actionIconContentColor = MaterialTheme.colorScheme.onBackground
        )
    )
}