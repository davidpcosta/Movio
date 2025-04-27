package me.davidcosta.movio.core.components.core.tab

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MovioTab(
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val style = if (selected) {
        MaterialTheme.typography.headlineMedium
    } else {
        MaterialTheme.typography.bodyMedium
    }
    Tab(
        text = {
            Text(
                text = title,
                style = style
            )
        },
        selected =  selected,
        unselectedContentColor = MaterialTheme.colorScheme.onBackground,
        onClick = onClick
    )
}