package me.davidcosta.movio.core.api.model.tvshow

import com.google.gson.annotations.SerializedName

data class ProductionCompanyModel(
    @SerializedName("id") val id: Int,
    @SerializedName("logo_path") val logoPath: String,
    @SerializedName("name") val name: String,
    @SerializedName("origin_country") val originCountry: String
)
