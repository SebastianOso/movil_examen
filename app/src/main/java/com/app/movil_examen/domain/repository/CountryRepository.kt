package com.app.movil_examen.domain.repository

import com.app.movil_examen.domain.model.Country

interface CountryRepository {
    suspend fun getCountryList(): List<Country>

    suspend fun getCountryById(id: String): Country
}