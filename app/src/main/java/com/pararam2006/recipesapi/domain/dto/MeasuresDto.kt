package com.pararam2006.recipesapi.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class MeasuresDto(
    val metric: MeasureDto,
    val us: MeasureDto,
)