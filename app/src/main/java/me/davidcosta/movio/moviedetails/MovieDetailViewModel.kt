package me.davidcosta.movio.moviedetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.launch
import me.davidcosta.movio.MovieDetailScreen
import me.davidcosta.movio.core.api.services.RetrofitInstance
import me.davidcosta.movio.core.domain.Movie
import me.davidcosta.movio.core.domain.toMovie

class MovieDetailViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val args = savedStateHandle.toRoute<MovieDetailScreen>()


    private var _movieDetail = mutableStateOf<Movie?>(null)
    val movieDetail: State<Movie?> = _movieDetail

    init {
        fetchMovieDetail(args.movieId)
    }

    private fun fetchMovieDetail(movieId: Long) {
        viewModelScope.launch {
            _movieDetail.value = RetrofitInstance.api
                .fetchMovieDetails(movieId = movieId)
                .toMovie()

        }
    }
}