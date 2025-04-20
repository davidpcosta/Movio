package me.davidcosta.movio.home.tabs.tvshows

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.davidcosta.movio.core.api.services.RetrofitInstance
import me.davidcosta.movio.core.api.services.TvShowApi
import me.davidcosta.movio.core.domain.Poster
import me.davidcosta.movio.core.domain.toShowPosterList

class TvShowsViewModel : ViewModel() {

    private var _onTheAirTvShows = mutableStateOf<List<Poster>>(emptyList())
    val onTheAirTvShows: State<List<Poster>> = _onTheAirTvShows

    private var _airingTodayTvShows = mutableStateOf<List<Poster>>(emptyList())
    val airingTodayTvShows: State<List<Poster>> = _airingTodayTvShows

    private var _popularTvShows = mutableStateOf<List<Poster>>(emptyList())
    val popularTvShows: State<List<Poster>> = _popularTvShows

    private var _topRatedTvShows = mutableStateOf<List<Poster>>(emptyList())
    val topRatedTvShows: State<List<Poster>> = _topRatedTvShows

    private val tvShowApi: TvShowApi
        get() = RetrofitInstance.tvShowApi

    init {
        fetchAiringTodayTvShows()
        fetchOnTheAirTvShows()
        fetchPopularTvShows()
        fetchTopRatedTvShows()
    }

    private fun fetchAiringTodayTvShows() {
        viewModelScope.launch {
            _airingTodayTvShows.value = tvShowApi
                .fetchAiringTodayShows()
                .toShowPosterList()
        }
    }

    private fun fetchOnTheAirTvShows() {
        viewModelScope.launch {
            _onTheAirTvShows.value = tvShowApi
                .fetchOnTheAirShows()
                .toShowPosterList()
        }
    }

    private fun fetchPopularTvShows() {
        viewModelScope.launch {
            _popularTvShows.value = tvShowApi
                .fetchPopularShows()
                .toShowPosterList()
        }
    }

    private fun fetchTopRatedTvShows() {
        viewModelScope.launch {
            _topRatedTvShows.value = tvShowApi
                .fetchTopRatedShows()
                .toShowPosterList()
        }
    }
}