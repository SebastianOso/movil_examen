package com.app.movil_examen.data.remote.dto

import com.app.movil_examen.data.remote.dto.CountryDto.FlagsDto
import com.google.gson.annotations.SerializedName


data class CountriesResponse(
    @SerializedName("name")
    val name: CountryNameDto,
    @SerializedName("flags")
    val flags: FlagsDto? = null,
    ) {
        data class CountryNameDto(
            @SerializedName("common")
            val common: String,
            @SerializedName("official")
            val official: String? = null,
        )
        data class FlagsDto(
            @SerializedName("png")
            val png: String? = null
        )
    }
