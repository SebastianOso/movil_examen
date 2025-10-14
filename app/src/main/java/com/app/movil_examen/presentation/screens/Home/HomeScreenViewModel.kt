package com.app.movil_examen.presentation.screens.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.movil_examen.domain.common.Result
import com.app.movil_examen.domain.usecase.GetCountriesStory
import com.app.movil_examen.presentation.screens.Home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("ktlint:standard:class-naming")
@HiltViewModel
class HomeScreenViewModel
@Inject
constructor(
    private val getCountriesStory: GetCountriesStory,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadCountryList()
    }

    private fun loadCountryList() {
        viewModelScope.launch {
            getCountriesStory().collect { result ->
                _uiState.update { state ->
                    when (result) {
                        is Result.Loading ->
                            state.copy(
                                isLoading = true,
                            )
                        is Result.Success ->
                            state.copy(
                                countryList = result.data,
                                isLoading = false,
                                error = null,
                            )
                        is Result.Error ->
                            state.copy(
                                error = result.exception.message,
                                isLoading = false,
                            )
                    }
                }
            }
        }
    }
}
