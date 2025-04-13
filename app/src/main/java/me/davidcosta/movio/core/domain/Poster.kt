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
    this.let { movie ->
        Poster(
            id = movie.id,
            title = movie.title,
            posterPath = movie.posterPath.fullPosterPath
        )
    }

fun ResultModel<TvShowModel>.toShowPosterList() =
    this.results.map {
        it.toPoster()
    }

fun TvShowModel.toPoster() =
    this.let { show ->
        Poster(
            id = show.id,
            title = show.name,
            posterPath = show.posterPath?.fullPosterPath.orEmpty()
        )
    }
