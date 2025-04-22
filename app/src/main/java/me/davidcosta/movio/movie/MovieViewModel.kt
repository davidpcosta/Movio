package me.davidcosta.movio.movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.launch
import me.davidcosta.movio.MovieScreenRoute
import me.davidcosta.movio.core.api.services.MovieApi
import me.davidcosta.movio.core.api.services.RetrofitInstance
import me.davidcosta.movio.core.domain.Movie
import me.davidcosta.movio.core.domain.toMovie

class MovieViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val args = savedStateHandle.toRoute<MovieScreenRoute>()

    private var _movieDetail = mutableStateOf<Movie?>(null)
    val movieDetail: State<Movie?> = _movieDetail

    private val movieApi: MovieApi
        get() = RetrofitInstance.movieApi

    init {
        fetchMovieDetail(args.movieId)
    }

    private fun fetchMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _movieDetail.value = movieApi
                .fetchMovieDetails(movieId = movieId)
                .toMovie()

        }
    }
}