package com.pararam2006.recipesapi.data.remote.dto

data class RecipesNetworkDto(
    val recipes: List<RecipeNetworkDto?>?,
    val spoonacularScore: Double?,
    val pricePerServing: Double?,
)
