package me.davidcosta.movio.core.api.model

import com.google.gson.annotations.SerializedName
import me.davidcosta.movio.core.api.model.core.CountryModel
import me.davidcosta.movio.core.api.model.core.GenreModel
import me.davidcosta.movio.core.api.model.core.LanguageModel
import java.time.LocalDate

class MovieDetailsModel(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("belongs_to_collection") val belongsToCollection: CollectionModel?,
    @SerializedName("budget") val budget: Double,
    @SerializedName("genres") val genres: List<GenreModel>,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("imdb_id") val imdbId: String,
    @SerializedName("origin_country") val originCountry: List<String>,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("production_companies") val productionCompanies: List<CompanyModel>,
    @SerializedName("production_countries") val productionCountries: List<CountryModel>,
    @SerializedName("release_date") val releaseDate: LocalDate?,
    @SerializedName("revenue") val revenue: Int,
    @SerializedName("runtime") val runtime: Int,
    @SerializedName("spoken_languages") val spokenLanguages: List<LanguageModel>,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String,
    @SerializedName("video") val video: Boolean,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("vote_count") val voteCount: Long,
)