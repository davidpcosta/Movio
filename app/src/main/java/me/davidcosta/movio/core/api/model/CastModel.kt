package me.davidcosta.movio.core.api.model

import com.google.gson.annotations.SerializedName

class CastModel (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("original_name") val originalName: String,
    @SerializedName("character") val character: String,
    @SerializedName("profile_path") val profilePath: String?,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("gender") val gender: Int,
    @SerializedName("knownForDepartment") val knownForDepartment: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("cast_id") val castId: Int,
    @SerializedName("credit_id") val creditId: String,
    @SerializedName("order") val order: Int
)