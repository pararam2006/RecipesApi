package com.pararam2006.recipesapi.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class MeasureDto(
    val amount: Double,
    val unitLong: String,
    val unitShort: String,
)