package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.MovieCreditsModel
import me.davidcosta.movio.core.utils.fullProfilePath

data class Character(
    val id: Int,
    val profilePath: String?,
    val name: String,
    val character: String
)

fun MovieCreditsModel.toCast() =
    this.cast.map {
        Character(
            id = it.id,
            profilePath = it.profilePath?.fullProfilePath,
            name = it.name,
            character = it.character
        )
    }