package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.VideoResultModel
import me.davidcosta.movio.core.utils.formatLongDate
import me.davidcosta.movio.core.utils.fullThumbPath
import me.davidcosta.movio.core.utils.fullVideoPath
import me.davidcosta.movio.core.utils.orNotAvailable

data class Video(
    val id: String,
    val name: String,
    val thumbPath: String,
    val videoPath: String,
    val publishedAt: String
)

fun VideoResultModel.toVideoList() =
    this.results.map { video ->
        Video(
            id = video.id,
            name = video.name.orEmpty(),
            thumbPath = video.key.fullThumbPath,
            videoPath = video.key.fullVideoPath,
            publishedAt = video.publishedAt?.formatLongDate().orNotAvailable()
        )
    }