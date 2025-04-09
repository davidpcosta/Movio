package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.core.ResultModel
import me.davidcosta.movio.core.api.model.MovieModel
import me.davidcosta.movio.core.utils.formattedVoteAverage
import me.davidcosta.movio.core.utils.fullPosterPath
import me.davidcosta.movio.core.utils.toLocalDate
import java.time.LocalDate

class Title(
    val title: String,
    val posterPath: String,
    val thumbPath: String,
    val voteAverage: String,
    val releaseDate: LocalDate
)

fun ResultModel<MovieModel>.toTitleList() =
    this.results.map {
        it.toTitle()
    }

fun MovieModel.toTitle() =
    this.let {
        Title(
            title = it.title,
            releaseDate = it.releaseDate.toLocalDate(),
            posterPath = it.posterPath.fullPosterPath,
            thumbPath = it.backdropPath.fullPosterPath,
            voteAverage = it.voteAverage.formattedVoteAverage
        )
    }
