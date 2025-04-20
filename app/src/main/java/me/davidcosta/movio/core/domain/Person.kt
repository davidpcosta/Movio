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
    val alsoKnownAs: List<String>?
)

fun PersonModel.toPerson() =
    this.let {
        Person(
            id = it.id,
            profilePath = it.profilePath.fullProfilePath,
            name = it.name,
            birthday = it.birthday.formatMediumDate(),
            placeOfBirth = it.placeOfBirth,
            biography = it.biography,
            alsoKnownAs = it.alsoKnownAs
        )
    }