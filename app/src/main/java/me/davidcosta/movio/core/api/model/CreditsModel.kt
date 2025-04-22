package me.davidcosta.movio.core.api.model

import com.google.gson.annotations.SerializedName

data class CreditsModel(
    @SerializedName("id") val id: Int,
    @SerializedName("cast") val cast: List<CastModel>
)