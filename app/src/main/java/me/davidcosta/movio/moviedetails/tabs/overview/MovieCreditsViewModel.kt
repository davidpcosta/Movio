package me.davidcosta.movio.moviedetails.tabs.overview

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.launch
import me.davidcosta.movio.MovieDetailScreen
import me.davidcosta.movio.core.api.services.RetrofitInstance
import me.davidcosta.movio.core.domain.Person
import me.davidcosta.movio.core.domain.toCast

class MovieCreditsViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val args = savedStateHandle.toRoute<MovieDetailScreen>()

    private var _moviePerson = mutableStateOf<List<Person>>(emptyList())
    val moviePerson: State<List<Person>> = _moviePerson

    init {
        fetchMovieCredits(args.movieId)
    }

    private fun fetchMovieCredits(movieId: Long) {
        viewModelScope.launch {
            _moviePerson.value = RetrofitInstance.api
                .fetchMovieCredits(movieId = movieId)
                .toCast()
        }
    }
}