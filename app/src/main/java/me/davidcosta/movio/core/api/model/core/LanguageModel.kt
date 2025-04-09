package me.davidcosta.movio.core.api.model.core

import com.google.gson.annotations.SerializedName

class LanguageModel(
    @SerializedName("iso_639_1") val iso: String,
    @SerializedName("english_name") val englishName: String,
    @SerializedName("name") val name: String
)