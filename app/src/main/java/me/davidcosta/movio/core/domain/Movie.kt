package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.MovieDetailModel
import me.davidcosta.movio.core.utils.formatYear
import me.davidcosta.movio.core.utils.formattedRuntime
import me.davidcosta.movio.core.utils.formattedVoteAverage
import me.davidcosta.movio.core.utils.fullPosterPath

class Movie(
    val title: String,
    val originalTitle: String,
    val posterPath: String,
    val releaseYear: String,
    val overview: String?,
    val runtime: String,
    val voteAverage: String,
    val genres: List<String>
)

fun MovieDetailModel.toMovie() =
    Movie(
        title = this.title,
        originalTitle = this.originalTitle,
        posterPath = this.posterPath.fullPosterPath,
        releaseYear = this.releaseDate.formatYear(),
        overview = this.overview,
        runtime = this.runtime.formattedRuntime,
        voteAverage = this.voteAverage.formattedVoteAverage,
        genres = this.genres.map { it.name }
    )