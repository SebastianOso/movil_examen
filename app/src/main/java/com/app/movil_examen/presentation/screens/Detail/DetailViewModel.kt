package com.app.movil_examen.presentation.screens.Detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.movil_examen.domain.usecase.GetCountryStory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.app.movil_examen.domain.common.Result

@HiltViewModel
class DetailViewModel
@Inject
constructor(
    private val getCountryStory: GetCountryStory,
) : ViewModel() {
    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun getCountry(name: String) {
        viewModelScope.launch {
            getCountryStory(name).collect { result ->
                _uiState.update { state ->
                    when (result) {
                        is Result.Loading ->
                            state.copy(
                                isLoading = true,
                            )
                        is Result.Success ->
                            state.copy(
                                country = result.data,
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