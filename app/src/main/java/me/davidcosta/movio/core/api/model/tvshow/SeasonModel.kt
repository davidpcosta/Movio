package me.davidcosta.movio.core.api.model.tvshow

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class SeasonModel(
    @SerializedName("id") val id: Int,
    @SerializedName("air_date") val airDate: LocalDate,
    @SerializedName("overview") val overview: String,
    @SerializedName("episode_count") val episodeCount: Int?,
    @SerializedName("name") val name: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("season_number") val seasonNumber: Int,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("episodes") val episodes: List<EpisodeModel>
)