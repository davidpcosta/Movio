package me.davidcosta.movio.core.api.model.person

import com.google.gson.annotations.SerializedName

enum class GenderModel {
    @SerializedName("0") UNSPECIFIED,
    @SerializedName("1") FEMALE,
    @SerializedName("2") MALE,
    @SerializedName("3") NON_BINARY
}