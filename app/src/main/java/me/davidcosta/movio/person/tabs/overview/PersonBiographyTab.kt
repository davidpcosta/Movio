package me.davidcosta.movio.person.tabs.overview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Person
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.utils.orDefault

@Composable
fun PersonBiographyTab(person: Person) {
    Column(
        modifier = Modifier
            .padding(horizontal = MaterialTheme.spacing.horizontalMargin)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.large),
            text = stringResource(R.string.person_details_screen_tab_biography_label_bio),
            style = MaterialTheme.typography.headlineLarge,
        )
        Text(
            text = person.biography.orDefault(stringResource(R.string.common_label_biography_unavailable)),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(top = MaterialTheme.spacing.small)
        )
        person.alsoKnownAs?.takeUnless { it.isEmpty() }?.let {
            Text(
                modifier = Modifier.padding(top = MaterialTheme.spacing.large),
                text = stringResource(R.string.person_details_screen_tab_biography_also_known_as_female),
                style = MaterialTheme.typography.headlineLarge,
            )
            Box(
                modifier = Modifier.padding(top = MaterialTheme.spacing.small)
            ) {
                Column {
                    person.alsoKnownAs.forEach { name ->
                        Text(
                            text = name,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
        }
    }
}