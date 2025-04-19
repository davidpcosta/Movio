package me.davidcosta.movio.core.api.model.person

import com.google.gson.annotations.SerializedName

data class PersonCreditsResultModel(
    @SerializedName("id") val id: Int,
    @SerializedName("cast") val cast: List<PersonCreditModel>
)