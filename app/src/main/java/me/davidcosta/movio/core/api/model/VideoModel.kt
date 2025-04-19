package me.davidcosta.movio.core.api.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class VideoModel(
    @SerializedName("id") val id: String,
    @SerializedName("key") val key: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("iso_639_1") val isoLanguage: String,
    @SerializedName("iso_3166_1") val isoCountry: String,
    @SerializedName("site") val site: String,
    @SerializedName("size") val size: Int,
    @SerializedName("type") val type: String,
    @SerializedName("official") val official: Boolean,
    @SerializedName("published_at") val publishedAt: LocalDateTime?
)