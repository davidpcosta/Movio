package me.davidcosta.movio.movie.tabs.overview

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
import me.davidcosta.movio.core.domain.Character
import me.davidcosta.movio.core.domain.toCast

class OverviewViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val args = savedStateHandle.toRoute<MovieDetailsScreenRoute>()

    private var _movieCharacter = mutableStateOf<List<Character>>(emptyList())
    val movieCharacter: State<List<Character>> = _movieCharacter

    private val movieApi: MovieApi
        get() = RetrofitInstance.movieApi

    init {
        fetchMovieCredits(args.movieId)
    }

    private fun fetchMovieCredits(movieId: Int) {
        viewModelScope.launch {
            _movieCharacter.value = movieApi
                .fetchMovieCredits(movieId = movieId)
                .toCast()
        }
    }
}