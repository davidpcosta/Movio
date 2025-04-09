package me.davidcosta.movio.core.api.model

import com.google.gson.annotations.SerializedName

class CompanyModel(
    @SerializedName("id") val id: Int,
    @SerializedName("logo_path") val logoPath: String,
    @SerializedName("name") val name: String,
    @SerializedName("origin_country") val originCountry: String
)