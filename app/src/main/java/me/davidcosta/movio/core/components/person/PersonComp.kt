package me.davidcosta.movio.core.components.person

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.davidcosta.movio.R
import me.davidcosta.movio.core.domain.Person
import me.davidcosta.movio.core.theme.AppTheme
import me.davidcosta.movio.core.theme.spacing

@Composable
fun PersonComp(
    modifier: Modifier = Modifier,
    personData: Person
) {
    Column(
        modifier = modifier
            .width(dimensionResource(R.dimen.people_profile_size))
    ) {
        Surface (
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            modifier = Modifier
                .size(dimensionResource(R.dimen.people_profile_size))
                .clickable {

                }
        ) {
            AsyncImage(
                model = personData.profilePath,
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(
                    R.string.people_image_content_description,
                    personData.character,
                    personData.name
                )
            )
        }
        Text(
            text = personData.name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = MaterialTheme.spacing.small)
        )
        Text(
            text = personData.character,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(top = MaterialTheme.spacing.tiny)
        )
    }
}

@Preview
@Composable
fun PersonCompPreview() {
    AppTheme(changeSystemBarStyle = false) {
        PersonComp(
            personData = Person (
                id = 1,
                name = "Rick Sanches",
                character = "Rick",
                profilePath = null
            )
        )
    }
}