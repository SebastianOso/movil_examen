package com.app.movil_examen.data.local.model

import com.app.movil_examen.domain.model.Country

data class CountryCache(
    val countryList: List<Country>,
    val lastUpdate: Long,
    val offset: Int,
    val totalCount: Int
)