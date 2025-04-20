package me.davidcosta.movio.person

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
import me.davidcosta.movio.core.domain.Person
import me.davidcosta.movio.core.domain.toPerson

class PersonDetailsViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val args = savedStateHandle.toRoute<PersonDetailsScreenRoute>()

    private var _person = mutableStateOf<Person?>(null)
    val person: State<Person?> = _person

    private val personApi: PersonApi
        get() = RetrofitInstance.personApi

    init {
        fetchPersonDetails(args.personId)
    }

    private fun fetchPersonDetails(personId: Int) {
        viewModelScope.launch {
            _person.value = personApi
                .fetchPersonDetails(personId = personId)
                .toPerson()
        }
    }
}