package me.davidcosta.movio.core.domain

import me.davidcosta.movio.core.api.model.common.MediaTypeModel

enum class MediaType {
    MOVIE,
    TV_SHOW
}

fun MediaTypeModel.toMediaType() =
    when (this) {
        MediaTypeModel.MOVIE -> MediaType.MOVIE
        MediaTypeModel.TV -> MediaType.TV_SHOW
    }