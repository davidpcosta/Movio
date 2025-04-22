package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.tvshow.EpisodeModel
import me.davidcosta.movio.core.utils.formatLongDate
import me.davidcosta.movio.core.utils.formattedRuntime
import me.davidcosta.movio.core.utils.fullStillPath

data class Episode(
    val id: Int,
    val episodeNumber: Int,
    val name: String,
    val overview: String?,
    val stillPath: String?,
    val airDate: String?,
    val runtime: String?
)

fun EpisodeModel.toEpisode(): Episode =
    Episode(
        id = id,
        episodeNumber = episodeNumber,
        name = name,
        overview = overview,
        stillPath = stillPath.fullStillPath,
        airDate = airDate.formatLongDate(),
        runtime = runtime.formattedRuntime
    )
