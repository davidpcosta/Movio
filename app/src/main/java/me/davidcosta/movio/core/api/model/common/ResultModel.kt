package me.davidcosta.movio.core.api.model.common

import com.google.gson.annotations.SerializedName

data class ResultModel<T> (
    @SerializedName("name") val page: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("results") val results: List<T>
)