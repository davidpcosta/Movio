package me.davidcosta.movio.core.api.model

import com.google.gson.annotations.SerializedName

data class MovieCreditsModel(
    @SerializedName("id") val id: Int,
    @SerializedName("cast") val cast: List<CastModel>
)