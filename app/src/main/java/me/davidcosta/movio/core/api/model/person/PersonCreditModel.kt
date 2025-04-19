package me.davidcosta.movio.core.api.model.person

import com.google.gson.annotations.SerializedName
import me.davidcosta.movio.core.api.model.core.MediaTypeModel
import java.time.LocalDate

data class PersonCreditModel(
    @SerializedName("id") val id: Int,
    @SerializedName("media_type") val mediaType: MediaTypeModel,
    @SerializedName("title") val title: String?,
    @SerializedName("original_title") val originalTitle: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("original_name") val originalName: String?,
    @SerializedName("character") val character: String?,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: LocalDate?,
    @SerializedName("first_air_date") val firstAirDate: LocalDate?,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("credit_id") val creditId: String,
    @SerializedName("order") val order: Int,
)