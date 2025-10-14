package com.app.movil_examen.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CountryNameDto(
    @SerializedName("common")
    val common: String,
    @SerializedName("official")
    val official: String? = null,
)