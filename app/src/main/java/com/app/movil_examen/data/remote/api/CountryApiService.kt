package com.app.movil_examen.data.remote.api

import com.app.movil_examen.data.remote.dto.CountriesDto
import com.app.movil_examen.data.remote.dto.CountryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApiService {
    @GET("all?fields=name")
    suspend fun getCountryList(): CountriesDto

    @GET("name/{name}")
    suspend fun getCountry(
        @Path("name") id: String,
    ): CountryDto
}