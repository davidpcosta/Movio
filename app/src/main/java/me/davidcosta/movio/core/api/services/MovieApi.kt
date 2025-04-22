package me.davidcosta.movio.core.api.services

import me.davidcosta.movio.core.api.model.CreditsModel
import me.davidcosta.movio.core.api.model.MovieDetailsModel
import me.davidcosta.movio.core.api.model.MovieModel
import me.davidcosta.movio.core.api.model.VideoResultModel
import me.davidcosta.movio.core.api.model.core.ResultModel
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
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
    ) : MovieDetailsModel

    @GET("movie/{movie_id}/credits?language=pt-BR")
    suspend fun fetchMovieCredits(
        @Path("movie_id") movieId: Int
    ) : CreditsModel

    @GET("movie/{movie_id}/similar?language=pt-BR")
    suspend fun fetchMovieSimilar(
        @Path("movie_id") movieId: Int
    ) : ResultModel<MovieModel>

    @GET("movie/{movie_id}/videos?language=pt-BR")
    suspend fun fetchMovieVideos(
        @Path("movie_id") movieId: Int
    ) : VideoResultModel
}