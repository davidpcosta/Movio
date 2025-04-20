package me.davidcosta.movio.tvshow

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
import me.davidcosta.movio.core.domain.TvShow
import me.davidcosta.movio.core.domain.toTvShow

class TvShowViewModel (
        savedStateHandle: SavedStateHandle
    ): ViewModel() {

        private val args = savedStateHandle.toRoute<TvShowScreenRoute>()

        private var _tvShowDetails = mutableStateOf<TvShow?>(null)
        val tvShowDetails: State<TvShow?> = _tvShowDetails

        private val tvShowApi: TvShowApi
            get() = RetrofitInstance.tvShowApi

        init {
            fetchTvShowDetails(args.tvShowId)
        }

        private fun fetchTvShowDetails(tvShowId: Int) {
            viewModelScope.launch {
                _tvShowDetails.value = tvShowApi
                    .fetchTvShowDetails(seriesId = tvShowId)
                    .toTvShow()
            }
        }
    }