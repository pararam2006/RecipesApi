package com.pararam2006.recipesapi.domain.dto

data class RecipesDto(
    val recipes: List<RecipeDto>,
    val spoonacularScore: Double,
    val pricePerServing: Double,
)
