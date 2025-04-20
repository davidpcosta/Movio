package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.core.ResultModel
import me.davidcosta.movio.core.api.model.TvShowModel
import me.davidcosta.movio.core.api.model.MovieModel
import me.davidcosta.movio.core.utils.fullPosterPath

class Poster(
    val id: Int,
    val title: String,
    val posterPath: String
)

fun ResultModel<MovieModel>.toMoviePosterList() =
    this.results.map {
        it.toPoster()
    }

fun MovieModel.toPoster() =
    Poster(
        id = this.id,
        title = this.title,
        posterPath = this.posterPath.fullPosterPath
    )


fun ResultModel<TvShowModel>.toShowPosterList() =
    this.results.map {
        it.toPoster()
    }

fun TvShowModel.toPoster() =
    Poster(
        id = this.id,
        title = this.name,
        posterPath = this.posterPath?.fullPosterPath.orEmpty()
    )

fun PersonCredit.toPoster() =
    Poster(
        id = this.id,
        title = this.title,
        posterPath = this.posterPath
    )
