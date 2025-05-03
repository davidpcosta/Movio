package me.davidcosta.movio.core.api.model.common

import com.google.gson.annotations.SerializedName
import me.davidcosta.movio.core.api.model.person.GenderModel

data class CreditModel(
    @SerializedName("id") val id: Int,
    @SerializedName("credit_id") val creditId: String,
    @SerializedName("name") val name: String,
    @SerializedName("original_name") val originalName: String,
    @SerializedName("gender") val gender: GenderModel,
    @SerializedName("profile_path") val profilePath: String,
)
