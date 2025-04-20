package me.davidcosta.movio.movie.tabs.trailers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.launch
import me.davidcosta.movio.MovieDetailsScreenRoute
import me.davidcosta.movio.core.api.services.MovieApi
import me.davidcosta.movio.core.api.services.RetrofitInstance
import me.davidcosta.movio.core.domain.Video
import me.davidcosta.movio.core.domain.toVideoList

class TrailersViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val args = savedStateHandle.toRoute<MovieDetailsScreenRoute>()

    private var _movieVideos = mutableStateOf<List<Video>>(emptyList())
    val movieVideos: State<List<Video>> = _movieVideos

    private val movieApi: MovieApi
        get() = RetrofitInstance.movieApi

    init {
        fetchMovieVideos(args.movieId)
    }

    private fun fetchMovieVideos(movieId: Int) {
        viewModelScope.launch {
            _movieVideos.value = movieApi
                .fetchMovieVideos(movieId = movieId)
                .toVideoList()
        }
    }
}