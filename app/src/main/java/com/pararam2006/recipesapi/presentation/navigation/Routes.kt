package com.pararam2006.recipesapi.presentation.navigation

import com.pararam2006.recipesapi.domain.dto.RecipeDto
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
sealed class Routes {
    @Serializable
    data object Main

    @Serializable
//    data object Details
    data class Details(
//        val recipe: RecipeDto,
        val recipeJson: String,
    ) {
        fun getRecipe(): RecipeDto {
            return Json.decodeFromString(recipeJson)
        }
    }
}
