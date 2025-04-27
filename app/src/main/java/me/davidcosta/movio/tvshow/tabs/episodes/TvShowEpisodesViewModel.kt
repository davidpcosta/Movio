package me.davidcosta.movio.tvshow.tabs.episodes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.davidcosta.movio.core.api.services.RetrofitInstance
import me.davidcosta.movio.core.api.services.TvShowApi
import me.davidcosta.movio.core.domain.Episode
import me.davidcosta.movio.core.domain.toEpisode

class TvShowEpisodesViewModel(
    tvShowId: Int,
    seasonNumber: Int
): ViewModel() {
    private var _episodes = mutableStateOf<List<Episode>>(emptyList())
    val episodes: State<List<Episode>> = _episodes

    private val tvShowApi: TvShowApi
        get() = RetrofitInstance.tvShowApi

    init {
        fetchTvShowEpisodes(tvShowId, seasonNumber)
    }

    private fun fetchTvShowEpisodes(tvShowId: Int, seasonNumber: Int) {
        viewModelScope.launch {
            _episodes.value = tvShowApi
                .fetchTvShowEpisodes(
                    seriesId = tvShowId,
                    seasonNumber = seasonNumber
                )
                .episodes.map {
                    it.toEpisode()
                }
        }
    }
}