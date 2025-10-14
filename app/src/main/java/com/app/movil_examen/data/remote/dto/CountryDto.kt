package com.app.movil_examen.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("name")
    val name: CountryNameDto,
    @SerializedName("population")
    val population: Int,
    @SerializedName("region")
    val region: String,
    @SerializedName("currencies")
    val currency: CurrencyDto,
    @SerializedName("languages")
    val languages: Map<String, String>? = null,
)