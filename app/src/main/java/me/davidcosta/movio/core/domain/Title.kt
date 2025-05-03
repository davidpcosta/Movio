package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.MovieModel
import me.davidcosta.movio.core.utils.formatYear
import me.davidcosta.movio.core.utils.formattedVoteAverage
import me.davidcosta.movio.core.utils.fullPosterPath

class Title(
    val title: String,
    val posterPath: String,
    val thumbPath: String,
    val voteAverage: String,
    val releaseYear: String?
)

fun MovieModel.toTitle() =
    Title(
        title = title,
        releaseYear = releaseDate.formatYear(),
        posterPath = posterPath.fullPosterPath,
        thumbPath = backdropPath.fullPosterPath,
        voteAverage = voteAverage.formattedVoteAverage
    )
