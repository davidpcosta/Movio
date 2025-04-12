package me.davidcosta.movio.core.api.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("id") val id: Int,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("title") val title: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("genre_ids") val genreIds: List<Int>?,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("video") val video: Boolean,
)