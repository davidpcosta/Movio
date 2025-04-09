package me.davidcosta.movio.core.utils.samples

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SampleList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(100) {
            Text(
                text = "Item $it",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}