package com.pararam2006.recipesapi.domain.usecase

import com.pararam2006.recipesapi.data.remote.repository.RecipeRepository
import com.pararam2006.recipesapi.domain.dto.RecipesDto

class GetRecipesUsecase(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(): RecipesDto? = repository.getRandomRecipes()
}
