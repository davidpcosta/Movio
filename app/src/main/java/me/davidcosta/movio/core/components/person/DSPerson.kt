package me.davidcosta.movio.core.components.person

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Character
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.color
import me.davidcosta.movio.core.theme.shapes
import me.davidcosta.movio.core.theme.spacing
import me.davidcosta.movio.core.theme.typography

@Composable
fun DSPerson(
    modifier: Modifier = Modifier,
    characterData: Character,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .width(dimensionResource(R.dimen.people_profile_size))
    ) {
        Surface (
            shape = DS.shapes.large,
            modifier = Modifier
                .size(dimensionResource(R.dimen.people_profile_size))
                .clickable {

                }
        ) {
            AsyncImage(
                modifier = Modifier.clickable { onClick() },
                model = characterData.profilePath,
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(
                    R.string.people_content_description_image,
                    characterData.character,
                    characterData.name
                )
            )
        }
        Text(
            text = characterData.name,
            style = DS.typography.headlineMedium,
            modifier = Modifier.padding(top = DS.spacing.small)
        )
        Text(
            text = characterData.character,
            style = DS.typography.titleSmall,
            color = DS.color.secondary,
            modifier = Modifier.padding(top = DS.spacing.tiny)
        )
    }
}

@Preview
@Composable
fun PreviewDSPerson() {
    AppTheme(changeSystemBarStyle = false) {
        DSPerson(
            characterData = Character(
                id = 1,
                name = "Rick Sanches",
                character = "Rick",
                profilePath = null
            ),
            onClick = {}
        )
    }
}