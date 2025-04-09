package me.davidcosta.movio.core.api.model.core

import com.google.gson.annotations.SerializedName

class CountryModel(
    @SerializedName("iso_3166_1") val iso: String,
    @SerializedName("name") val name: String
)