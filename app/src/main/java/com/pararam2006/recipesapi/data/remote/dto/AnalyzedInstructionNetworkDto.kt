package com.pararam2006.recipesapi.data.remote.dto

data class AnalyzedInstructionNetworkDto(
    val name: String?,
    val steps: List<StepNetworkDto?>?,
    val spoonacularScore: Double?,
    val spoonacularSourceUrl: String?,
)