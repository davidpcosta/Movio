package me.davidcosta.movio.core.api.model

import com.google.gson.annotations.SerializedName

data class TvShowModel(
    @SerializedName("id") val id: Long,
    @SerializedName("original_name") val originalName: String,
    @SerializedName("name") val name: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("first_air_date") val firstAirDate: String,
    @SerializedName("origin_country") val originCountry: List<String>,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("adult") val adult: String,
)