package me.davidcosta.movio.tvshow.tabs.overview

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.launch
import me.davidcosta.movio.TvShowScreenRoute
import me.davidcosta.movio.core.api.services.RetrofitInstance
import me.davidcosta.movio.core.api.services.TvShowApi
import me.davidcosta.movio.core.domain.Character
import me.davidcosta.movio.core.domain.toCharacterList

class TvShowOverviewViewModel (
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val args = savedStateHandle.toRoute<TvShowScreenRoute>()

    private var _tvShowCharacter = mutableStateOf<List<Character>>(emptyList())
    val tvShowCharacter: State<List<Character>> = _tvShowCharacter

    private val tvShowApi: TvShowApi
        get() = RetrofitInstance.tvShowApi

    init {
        fetchTvShowCredits(args.tvShowId)
    }

    private fun fetchTvShowCredits(tvShowId: Int) {
        viewModelScope.launch {
            _tvShowCharacter.value = tvShowApi
                .fetchTvShowCredits(seriesId = tvShowId)
                .toCharacterList()
        }
    }
}