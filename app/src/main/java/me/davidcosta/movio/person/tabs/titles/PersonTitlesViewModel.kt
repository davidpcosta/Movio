package me.davidcosta.movio.person.tabs.titles

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.launch
import me.davidcosta.movio.PersonDetailsScreenRoute
import me.davidcosta.movio.core.api.services.PersonApi
import me.davidcosta.movio.core.api.services.RetrofitInstance
import me.davidcosta.movio.core.domain.PersonCredit
import me.davidcosta.movio.core.domain.toPersonCreditList

class PersonTitlesViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val args = savedStateHandle.toRoute<PersonDetailsScreenRoute>()

    private var _personCredits = mutableStateOf<List<PersonCredit>>(emptyList())
    val personCredits: State<List<PersonCredit>> = _personCredits

    private val personApi: PersonApi
        get() = RetrofitInstance.personApi

    init {
        fetchPersonCredits(args.personId)
    }

    private fun fetchPersonCredits(personId: Int) {
        viewModelScope.launch {
            _personCredits.value = personApi
                .fetchPersonCredits(personId = personId)
                .toPersonCreditList()
                .sortedByDescending { it.releaseYear }
                .let { fullList ->
                    fullList.filterNot { it.releaseYear.isNullOrBlank() }
                        .plus(
                            fullList.filter { it.releaseYear.isNullOrBlank() }
                        )
                }
        }
    }
}