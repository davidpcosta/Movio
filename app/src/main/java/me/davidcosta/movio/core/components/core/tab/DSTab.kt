package me.davidcosta.movio.core.components.core.tab

import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.color
import me.davidcosta.movio.core.theme.typography

@Composable
fun DSTab(
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val style = if (selected) {
        DS.typography.headlineMedium
    } else {
        DS.typography.bodyMedium
    }
    Tab(
        text = {
            Text(
                text = title,
                style = style
            )
        },
        selected =  selected,
        unselectedContentColor = DS.color.onBackground,
        onClick = onClick
    )
}

@Preview
@Composable
fun PreviewDSTab() {
    AppTheme(changeSystemBarStyle = false) {
        DSTab(
            title = "Tab 01",
            selected = false,
            onClick = {}
        )
    }
}