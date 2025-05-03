package me.davidcosta.movio.core.api.model.tvshow

import com.google.gson.annotations.SerializedName
import me.davidcosta.movio.core.api.model.common.CountryModel
import me.davidcosta.movio.core.api.model.common.CreditModel
import me.davidcosta.movio.core.api.model.common.GenreModel
import me.davidcosta.movio.core.api.model.common.LanguageModel
import java.time.LocalDate

data class TvShowDetailsModel(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("created_by") val createdBy: List<CreditModel>,
    @SerializedName("episode_run_time") val episodeRunTime: Any,
    @SerializedName("first_air_date") val firstAirDate: LocalDate,
    @SerializedName("genres") val genres: List<GenreModel>,
    @SerializedName("homepage") val homepage: String,
    @SerializedName("id") val id: Int,
    @SerializedName("in_production") val inProduction: Boolean,
    @SerializedName("languages") val languages: List<String>,
    @SerializedName("last_air_date") val lastAirDate: LocalDate,
    @SerializedName("last_episode_to_air") val lastEpisodeToAir: EpisodeModel,
    @SerializedName("name") val name: String,
    @SerializedName("next_episode_to_air") val nextEpisodeToAir: EpisodeModel,
    @SerializedName("networks") val networks: List<NetworkModel>,
    @SerializedName("number_of_episodes") val numberOfEpisodes: Int,
    @SerializedName("number_of_seasons") val numberOfSeasons: Int,
    @SerializedName("origin_country") val originCountry: List<String>,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_name") val originalName: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompanyModel>,
    @SerializedName("production_countries") val productionCountries: List<CountryModel>,
    @SerializedName("seasons") val seasons: List<SeasonModel>,
    @SerializedName("spoken_languages") val spokenLanguages: List<LanguageModel>,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String,
    @SerializedName("type") val type: String,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("vote_count") val voteCount: Int
)
