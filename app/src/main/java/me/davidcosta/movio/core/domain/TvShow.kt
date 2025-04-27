package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.tvshow.TvShowDetailsModel
import me.davidcosta.movio.core.utils.formattedVoteAverage
import me.davidcosta.movio.core.utils.fullPosterPath

data class TvShow(
    val id: Int,
    val name: String,
    val originalName: String,
    val overview: String?,
    val posterPath: String,
    val seasonsCount: Int,
    val firstAirYear: String?,
    val voteAverage: String,
    val genres: List<String>,
    val seasons: List<Season>
)

fun TvShowDetailsModel.toTvShow() =
    TvShow(
        id = id,
        name = name,
        originalName = originalName,
        overview = overview,
        seasonsCount = numberOfSeasons,
        posterPath = posterPath.fullPosterPath,
        firstAirYear = firstAirDate.year.toString(),
        voteAverage = voteAverage.formattedVoteAverage,
        genres = genres.map { it.name },
        seasons = seasons.sortedByDescending { it.seasonNumber }.map { it.toSeason() }
    )