package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.MovieDetailsModel
import me.davidcosta.movio.core.utils.formatYear
import me.davidcosta.movio.core.utils.formattedRuntime
import me.davidcosta.movio.core.utils.formattedVoteAverage
import me.davidcosta.movio.core.utils.fullPosterPath

class Movie(
    val title: String,
    val originalTitle: String,
    val posterPath: String,
    val releaseYear: String?,
    val overview: String?,
    val runtime: String,
    val voteAverage: String,
    val genres: List<String>
)

fun MovieDetailsModel.toMovie() =
    Movie(
        title = title,
        originalTitle = originalTitle,
        posterPath = posterPath.fullPosterPath,
        releaseYear = releaseDate.formatYear(),
        overview = overview,
        runtime = runtime.formattedRuntime,
        voteAverage = voteAverage.formattedVoteAverage,
        genres = genres.map { it.name }
    )