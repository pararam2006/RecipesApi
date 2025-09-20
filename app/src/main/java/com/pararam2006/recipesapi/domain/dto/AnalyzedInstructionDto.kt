package com.pararam2006.recipesapi.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class AnalyzedInstructionDto(
    val name: String,
    val steps: List<StepDto>,
    val spoonacularScore: Double,
    val spoonacularSourceUrl: String,
)
