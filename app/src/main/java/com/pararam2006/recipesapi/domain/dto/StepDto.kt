package com.pararam2006.recipesapi.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class StepDto(
    val number: Int,
    val step: String,
    val ingredients: List<StepIngredientDto>,
    val equipment: List<EquipmentDto>,
    val length: LengthDto,
)