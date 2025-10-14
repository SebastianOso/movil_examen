package com.app.movil_examen.data.mapper

import com.app.movil_examen.data.remote.dto.CountriesResponse
import com.app.movil_examen.data.remote.dto.CountryDto
import com.app.movil_examen.domain.model.Country

fun CountryDto.toDomain(): Country =
    Country(
        name = name.common,
        population = population.toString(),
        region = region,
        currency = currency.name ?: "Unknown",
        languages = languages?.values?.joinToString(", ") ?: "Unknown"
    )

fun CountriesResponse.toDomain(): Country =
    Country(
        name = name.common,
        population = "N/A",
        region = "N/A",
        currency = "N/A",
        languages = "N/A"
    )