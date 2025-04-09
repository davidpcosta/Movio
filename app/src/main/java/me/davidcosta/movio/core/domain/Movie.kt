package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.MovieDetailModel
import me.davidcosta.movio.core.utils.formattedRuntime
import me.davidcosta.movio.core.utils.formattedVoteAverage
import me.davidcosta.movio.core.utils.fullPosterPath
import me.davidcosta.movio.core.utils.toLocalDate
import java.time.LocalDate

class Movie(
    val title: String,
    val posterPath: String,
    val releaseDate: LocalDate,
    val overview: String,
    val runtime: String,
    val voteAverage: String,
    val genres: List<String>
)

fun MovieDetailModel.toMovie() =
    Movie(
        title = this.title,
        posterPath = this.posterPath.fullPosterPath,
        releaseDate = this.releaseDate.toLocalDate(),
        overview = this.overview,
        runtime = this.runtime.formattedRuntime,
        voteAverage = this.voteAverage.formattedVoteAverage,
        genres = this.genres.map { it.name }
    )