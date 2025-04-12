package me.davidcosta.movio.core.api.model

import com.google.gson.annotations.SerializedName

data class VideoResultModel(
    @SerializedName("id") val id: Int,
    @SerializedName("results") val results: List<VideoModel>
)