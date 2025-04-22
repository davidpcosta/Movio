package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.tvshow.SeasonModel

data class Season(
    val id: Int,
    val seasonNumber: Int,
    val name: String,
    val overview: String?
)

fun SeasonModel.toSeason(): Season =
    Season(
        id = id,
        seasonNumber = seasonNumber,
        name = name,
        overview = overview
    )
