package me.davidcosta.movio.core.api.model.tvshow

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class SeasonModel(
    @SerializedName("air_date") val airDate: LocalDate,
    @SerializedName("episode_count") val episodeCount: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("season_number") val seasonNumber: Int,
    @SerializedName("vote_average") val voteSverage: Float
)