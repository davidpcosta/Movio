package me.davidcosta.movio.home.tabs.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.davidcosta.movio.core.api.services.MovieApi
import me.davidcosta.movio.core.api.services.RetrofitInstance
import me.davidcosta.movio.core.domain.Poster
import me.davidcosta.movio.core.domain.toMoviePosterList

class MoviesViewModel : ViewModel() {

    private var _nowPlayingTitles = mutableStateOf<List<Poster>>(emptyList())
    val nowPlayingTitles: State<List<Poster>> = _nowPlayingTitles

    private var _popularTitles = mutableStateOf<List<Poster>>(emptyList())
    val popularTitles: State<List<Poster>> = _popularTitles

    private var _topRatedTitles = mutableStateOf<List<Poster>>(emptyList())
    val topRatedTitles: State<List<Poster>> = _topRatedTitles

    private var _upcomingTitles = mutableStateOf<List<Poster>>(emptyList())
    val upcomingTitles: State<List<Poster>> = _upcomingTitles

    private val movieApi: MovieApi
        get() = RetrofitInstance.movieApi

    init {
        fetchNowPlayingTitles()
        fetchPopularTitles()
        fetchTopRatedTitles()
        fetchUpComingTitles()
    }

    private fun fetchNowPlayingTitles() {
        viewModelScope.launch {
            _nowPlayingTitles.value = movieApi
                .fetchNowPlayingMovies()
                .toMoviePosterList()
        }
    }

    private fun fetchPopularTitles() {
        viewModelScope.launch {
            _popularTitles.value = movieApi
                .fetchNowPlayingMovies()
                .toMoviePosterList()
        }
    }

    private fun fetchTopRatedTitles() {
        viewModelScope.launch {
            _topRatedTitles.value = movieApi
                .fetchTopRatedMovies()
                .toMoviePosterList()
        }
    }

    private fun fetchUpComingTitles() {
        viewModelScope.launch {
            _upcomingTitles.value = movieApi
                .fetchUpcomingMovies()
                .toMoviePosterList()
        }
    }
}