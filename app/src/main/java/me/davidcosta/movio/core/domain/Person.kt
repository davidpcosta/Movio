package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.person.PersonModel
import me.davidcosta.movio.core.utils.formatMediumDate
import me.davidcosta.movio.core.utils.fullProfilePath

data class Person(
    val id: Int,
    val profilePath: String,
    val name: String,
    val birthday: String?,
    val placeOfBirth: String?,
    val biography: String?,
    val knownForDepartment: String,
    val gender: Gender,
    val alsoKnownAs: List<String>?
)

fun PersonModel.toPerson() =
    Person(
        id = id,
        profilePath = profilePath.fullProfilePath,
        name = name,
        birthday = birthday.formatMediumDate(),
        placeOfBirth = placeOfBirth,
        biography = biography,
        knownForDepartment = knownForDepartment,
        gender = gender.toGender(),
        alsoKnownAs = alsoKnownAs
    )