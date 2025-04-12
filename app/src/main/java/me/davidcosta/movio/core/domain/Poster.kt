package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.core.ResultModel
import me.davidcosta.movio.core.api.model.TvShowModel
import me.davidcosta.movio.core.api.model.MovieModel
import me.davidcosta.movio.core.utils.formatYear
import me.davidcosta.movio.core.utils.formattedVoteAverage
import me.davidcosta.movio.core.utils.fullPosterPath

class Poster(
    val id: Int,
    val title: String,
    val posterPath: String,
    val voteAverage: String,
    val releaseYear: String
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
            releaseYear = movie.releaseDate.formatYear(),
            posterPath = movie.posterPath.fullPosterPath,
            voteAverage = movie.voteAverage.formattedVoteAverage
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
            releaseYear = "2025",
            posterPath = show.posterPath?.fullPosterPath.orEmpty(),
            voteAverage = show.voteAverage.formattedVoteAverage
        )
    }
