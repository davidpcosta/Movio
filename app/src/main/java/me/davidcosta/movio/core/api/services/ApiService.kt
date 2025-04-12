package me.davidcosta.movio.core.api.services

import me.davidcosta.movio.core.api.model.MovieCreditsModel
import me.davidcosta.movio.core.api.model.MovieDetailModel
import me.davidcosta.movio.core.api.model.core.ResultModel
import me.davidcosta.movio.core.api.model.TvShowModel
import me.davidcosta.movio.core.api.model.MovieModel
import me.davidcosta.movio.core.api.model.VideoResultModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    // region: Movies
    @GET("movie/now_playing?language=pt-BR")
    suspend fun fetchNowPlayingMovies() : ResultModel<MovieModel>

    @GET("movie/popular?language=pt-BR")
    suspend fun fetchPopularMovies() : ResultModel<MovieModel>

    @GET("movie/top_rated?language=pt-BR")
    suspend fun fetchTopRatedMovies() : ResultModel<MovieModel>

    @GET("movie/upcoming?language=pt-BR")
    suspend fun fetchUpcomingMovies() : ResultModel<MovieModel>

    @GET("movie/{movie_id}?language=pt-BR")
    suspend fun fetchMovieDetails(
        @Path("movie_id") movieId: Int
    ) : MovieDetailModel

    @GET("movie/{movie_id}/credits?language=pt-BR")
    suspend fun fetchMovieCredits(
        @Path("movie_id") movieId: Int
    ) : MovieCreditsModel

    @GET("movie/{movie_id}/similar?language=pt-BR")
    suspend fun fetchMovieSimilar(
        @Path("movie_id") movieId: Int
    ) : ResultModel<MovieModel>

    @GET("movie/{movie_id}/videos?language=pt-BR")
    suspend fun fetchMovieVideos(
        @Path("movie_id") movieId: Int
    ) : VideoResultModel
    // endregion


    // region: TV Show
    @GET("tv/airing_today?language=pt-BR")
    suspend fun fetchAiringTodayShows() : ResultModel<TvShowModel>

    @GET("tv/on_the_air?language=pt-BR")
    suspend fun fetchOnTheAirShows() : ResultModel<TvShowModel>

    @GET("tv/popular?language=pt-BR")
    suspend fun fetchPopularShows() : ResultModel<TvShowModel>

    @GET("tv/top_rated?language=pt-BR")
    suspend fun fetchTopRatedShows() : ResultModel<TvShowModel>
    // endregion
}