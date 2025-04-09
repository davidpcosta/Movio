package me.davidcosta.movio.core.api.model.core

import com.google.gson.annotations.SerializedName

class GenreModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)