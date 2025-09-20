package com.pararam2006.recipesapi.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipeDto(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String,
    val servings: Int,
    val readyMinutes: Int,
    val cookingMinutes: Int,
    val preparationMinutes: Int,
    val aggregateLikes: Int,
    val license: String,
    val sourceName: String,
    val sourceUrl: String,
    val spoonacularSourceUrl: String,
    val healthScore: Int,
    val spoonacularScore: Double,
    val pricePerServing: Double,
    val analyzedInstructions: List<AnalyzedInstructionDto>, //Неточно
    val cheap: Boolean,
    val creditsText: String,
    val cuisines: List<String>, //Неточно
    val diets: List<String>, //Неточно
    val gaps: String,
    val glutenFree: Boolean,
    val instructions: String,
    val ketogenic: Boolean,
    val lowFodmap: Boolean,
    val occasions: List<String>,
    val sustainable: Boolean,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val whole30: Boolean,
    val weightWatcherSmartPoints: Int,
    val dishTypes: List<String>,
    val extendedIngredients: List<ExtendedIngredientDto>,
    val summary: String,
    val winePairing: WinePairingDto,
)
