package com.app.movil_examen.data.repository

import android.util.Log
import com.app.movil_examen.data.local.preferences.CountryPreferences
import com.app.movil_examen.data.mapper.toDomain
import com.app.movil_examen.data.remote.api.CountryApiService
import com.app.movil_examen.domain.model.Country
import com.app.movil_examen.domain.repository.CountryRepository
import javax.inject.Inject


class CountryRepositoryImpl
@Inject
constructor(
    private val api: CountryApiService,
    private val preferences: CountryPreferences,
) : CountryRepository {
    override suspend fun getCountryList(): List<Country> {
        // Intentar obtener del caché primero
        preferences.getCountryCache()?.let { cache ->
            if (preferences.isCacheValid()) {
                return cache.countryList
            }
        }

        return try {
            // Si no hay caché o expiró, obtener de la API
            val response = api.getCountryList()
            val countryList = response.map { it.toDomain() }

            // Guardar en caché
            preferences.saveCountryList(
                countryList = countryList,
                offset = countryList.size,
                totalCount = countryList.size, // o el campo count si lo tiene tu API
            )

            countryList
        } catch (e: Exception) {
            // Si hay error, intentar usar caché aunque haya expirado
            preferences.getCountryCache()?.let { cache ->
                return cache.countryList
            } ?: throw e
        }
    }

    //se uso chat para que funcionara esta funcion, porque a la hroa de hacer el detail screen no jalaba
    override suspend fun getCountryById(id: String): Country {
        val response = api.getCountry(id)
        return response.firstOrNull()?.toDomain()
            ?: throw Exception("Country not found")
    }

}