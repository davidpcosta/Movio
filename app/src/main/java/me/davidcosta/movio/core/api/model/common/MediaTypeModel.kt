package me.davidcosta.movio.core.api.model.common

import com.google.gson.annotations.SerializedName

enum class MediaTypeModel {
    @SerializedName("movie") MOVIE,
    @SerializedName("tv") TV;
}