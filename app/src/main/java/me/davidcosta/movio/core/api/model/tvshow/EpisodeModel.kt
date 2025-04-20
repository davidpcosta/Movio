package me.davidcosta.movio.core.api.model.tvshow

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class EpisodeModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("air_date") val airDate: LocalDate,
    @SerializedName("episode_number") val episodeNumber: Int,
    @SerializedName("episode_type") val episodeType: String,
    @SerializedName("production_code") val productionCode: String,
    @SerializedName("runtime") val runtime: Int,
    @SerializedName("season_number") val seasonNumber: Int,
    @SerializedName("show_id") val showId: Int,
    @SerializedName("still_path") val stillPath: String
)
