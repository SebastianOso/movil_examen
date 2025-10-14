package com.app.movil_examen.data.repository

import com.app.movil_examen.data.mapper.toDomain
import com.app.movil_examen.data.remote.api.CountryApiService
import com.app.movil_examen.domain.model.Country
import com.app.movil_examen.domain.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl
@Inject
constructor(
    private val api: CountryApiService,
) : CountryRepository {
    override suspend fun getCountryList(): List<Country> {
        val response = api.getCountryList()
        return response.map { it.toDomain() }
    }

    override suspend fun getCountryById(id: String): Country = api.getCountry(id).toDomain()
}