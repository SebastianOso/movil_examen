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
) {
    data class CountryNameDto(
        @SerializedName("common")
        val common: String,
        @SerializedName("official")
        val official: String? = null,
    )

    data class CurrencyDto(
        @SerializedName("symbol")
        val symbol: String? = null,
        @SerializedName("name")
        val name: String? = null
    )
}