package com.app.movil_examen.presentation.screens.Home

import com.app.movil_examen.domain.model.Country

@Suppress("ktlint:standard:class-naming")
data class HomeUiState(
    val countryList: List<Country> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)