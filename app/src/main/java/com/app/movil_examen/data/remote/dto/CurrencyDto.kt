package com.app.movil_examen.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CurrencyDto(
    @SerializedName("symbol")
    val symbol: String? = null,
    @SerializedName("name")
    val name: String? = null
)