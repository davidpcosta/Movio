package me.davidcosta.movio.moviedetails.tabs.similar

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.launch
import me.davidcosta.movio.MovieDetailsScreen
import me.davidcosta.movio.core.api.services.RetrofitInstance
import me.davidcosta.movio.core.domain.Poster
import me.davidcosta.movio.core.domain.toMoviePosterList

class SimilarViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val args = savedStateHandle.toRoute<MovieDetailsScreen>()

    private var _similarMovies = mutableStateOf<List<Poster>>(emptyList())
    val similarMovies: State<List<Poster>> = _similarMovies

    init {
        fetchSimilarMovies(args.movieId)
    }

    private fun fetchSimilarMovies(movieId: Int) {
        viewModelScope.launch {
            _similarMovies.value = RetrofitInstance.api
                .fetchMovieSimilar(movieId = movieId)
                .toMoviePosterList()
        }
    }
}