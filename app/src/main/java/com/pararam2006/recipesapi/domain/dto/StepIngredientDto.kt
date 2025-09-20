package com.pararam2006.recipesapi.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class StepIngredientDto(
    val id: Int,
    val name: String,
    val localizedName: String,
    val image: String,
)
