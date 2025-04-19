package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.core.MediaTypeModel
import me.davidcosta.movio.core.api.model.person.PersonCreditModel
import me.davidcosta.movio.core.api.model.person.PersonCreditsResultModel
import me.davidcosta.movio.core.utils.formatYear
import me.davidcosta.movio.core.utils.orNotAvailable
import java.time.LocalDate

data class PersonCredit(
    val id: Int,
    val mediaType: MediaType,
    val title: String,
    val character: String,
    val releaseYear: String?
)

fun PersonCreditsResultModel.toPersonCreditList() =
    this.cast
        .map { it.toPersonCredit() }

fun PersonCreditModel.title(): String =
    when(this.mediaType) {
        MediaTypeModel.MOVIE -> this.title
        MediaTypeModel.TV -> this.name
    }.orNotAvailable()

fun PersonCreditModel.releaseDate(): LocalDate? =
    when(this.mediaType) {
        MediaTypeModel.MOVIE -> this.releaseDate
        MediaTypeModel.TV -> this.firstAirDate
    }

fun PersonCreditModel.toPersonCredit() =
    PersonCredit(
        id = this.id,
        mediaType = this.mediaType.toMediaType(),
        title = this.title(),
        character = this.character.orNotAvailable(),
        releaseYear = this.releaseDate.formatYear()
    )