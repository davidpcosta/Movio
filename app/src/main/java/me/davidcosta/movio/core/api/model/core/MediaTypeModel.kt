package me.davidcosta.movio.core.api.model.core

import com.google.gson.annotations.SerializedName

enum class MediaTypeModel {
    @SerializedName("movie") MOVIE,
    @SerializedName("tv") TV;
}