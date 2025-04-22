package me.davidcosta.movio.core.domain

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import me.davidcosta.movio.R
import me.davidcosta.movio.core.api.model.person.GenderModel

enum class Gender {
    FEMALE,
    MALE,
    NON_BINARY,
    UNSPECIFIED
}

fun GenderModel.toGender(): Gender =
    when (this) {
        GenderModel.UNSPECIFIED -> Gender.UNSPECIFIED
        GenderModel.FEMALE -> Gender.FEMALE
        GenderModel.MALE -> Gender.MALE
        GenderModel.NON_BINARY -> Gender.NON_BINARY
    }

@Composable
@ReadOnlyComposable
fun Gender.label(): String =
    when (this) {
        Gender.UNSPECIFIED -> stringResource(R.string.gender_label_unspecified)
        Gender.FEMALE ->stringResource(R.string.gender_label_female)
        Gender.MALE ->stringResource(R.string.gender_label_male)
        Gender.NON_BINARY -> stringResource(R.string.gender_label_non_binary)
    }


@Composable
@ReadOnlyComposable
fun Gender.labelKnownAs(): String =
    when (this) {
        Gender.UNSPECIFIED -> stringResource(R.string.person_details_screen_tab_biography_label_known_as_male)
        Gender.FEMALE ->stringResource(R.string.person_details_screen_tab_biography_label_known_as_female)
        Gender.MALE ->stringResource(R.string.person_details_screen_tab_biography_label_known_as_male)
        Gender.NON_BINARY -> stringResource(R.string.person_details_screen_tab_biography_label_known_as_non_binary)
    }

@Composable
@ReadOnlyComposable
fun Gender.labelAlsoKnownAs(): String =
    when (this) {
        Gender.UNSPECIFIED -> stringResource(R.string.person_details_screen_tab_biography_label_also_known_as_male)
        Gender.FEMALE ->stringResource(R.string.person_details_screen_tab_biography_label_also_known_as_female)
        Gender.MALE ->stringResource(R.string.person_details_screen_tab_biography_label_also_known_as_male)
        Gender.NON_BINARY -> stringResource(R.string.person_details_screen_tab_biography_label_also_known_as_non_binary)
    }