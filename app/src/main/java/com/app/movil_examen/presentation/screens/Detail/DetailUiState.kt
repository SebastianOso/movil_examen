package com.app.movil_examen.presentation.screens.Detail

import com.app.movil_examen.domain.model.Country

data class DetailUiState(
    val country: Country? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)