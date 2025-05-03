package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.common.ResultModel
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
        id = id,
        title = title,
        posterPath = posterPath.fullPosterPath
    )


fun ResultModel<TvShowModel>.toShowPosterList() =
    this.results.map {
        it.toPoster()
    }

fun TvShowModel.toPoster() =
    Poster(
        id = id,
        title = name,
        posterPath = posterPath?.fullPosterPath.orEmpty()
    )

fun PersonCredit.toPoster() =
    Poster(
        id = id,
        title = title,
        posterPath = posterPath
    )
