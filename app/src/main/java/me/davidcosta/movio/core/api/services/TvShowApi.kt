package me.davidcosta.movio.core.api.services

import me.davidcosta.movio.core.api.model.CreditsModel
import me.davidcosta.movio.core.api.model.TvShowModel
import me.davidcosta.movio.core.api.model.core.ResultModel
import me.davidcosta.movio.core.api.model.tvshow.SeasonModel
import me.davidcosta.movio.core.api.model.tvshow.TvShowDetailsModel
import retrofit2.http.GET
import retrofit2.http.Path

interface TvShowApi {
    @GET("tv/airing_today?language=pt-BR")
    suspend fun fetchAiringTodayShows() : ResultModel<TvShowModel>

    @GET("tv/on_the_air?language=pt-BR")
    suspend fun fetchOnTheAirShows() : ResultModel<TvShowModel>

    @GET("tv/popular?language=pt-BR")
    suspend fun fetchPopularShows() : ResultModel<TvShowModel>

    @GET("tv/top_rated?language=pt-BR")
    suspend fun fetchTopRatedShows() : ResultModel<TvShowModel>

    @GET("tv/{series_id}?language=pt-BR")
    suspend fun fetchTvShowDetails(
        @Path("series_id") seriesId: Int
    ) : TvShowDetailsModel

    @GET("tv/{series_id}/credits?language=pt-BR")
    suspend fun fetchTvShowCredits(
        @Path("series_id") seriesId: Int
    ) : CreditsModel

    @GET("tv/{series_id}/season/{season_number}?language=pt-BR")
    suspend fun fetchTvShowEpisodes(
        @Path("series_id") seriesId: Int,
        @Path("season_number") seasonNumber: Int
    ) : SeasonModel
}