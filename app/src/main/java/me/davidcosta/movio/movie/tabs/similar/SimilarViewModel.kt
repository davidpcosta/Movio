package me.davidcosta.movio.movie.tabs.similar

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
import me.davidcosta.movio.core.domain.Poster
import me.davidcosta.movio.core.domain.toMoviePosterList

class SimilarViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val args = savedStateHandle.toRoute<MovieDetailsScreenRoute>()

    private var _similarMovies = mutableStateOf<List<Poster>>(emptyList())
    val similarMovies: State<List<Poster>> = _similarMovies

    private val movieApi: MovieApi
        get() = RetrofitInstance.movieApi

    init {
        fetchSimilarMovies(args.movieId)
    }

    private fun fetchSimilarMovies(movieId: Int) {
        viewModelScope.launch {
            _similarMovies.value = movieApi
                .fetchMovieSimilar(movieId = movieId)
                .toMoviePosterList()
        }
    }
}