package com.pararam2006.recipesapi.domain.usecase

import com.pararam2006.recipesapi.data.repository.RecipeRepository
import com.pararam2006.recipesapi.domain.dto.RecipesDto

class GetRecipesUsecase(
    private val repository: RecipeRepository
) {
    // Основной метод для первоначальной загрузки с кэшированием
    suspend operator fun invoke(): RecipesDto? = repository.getRandomRecipes(skipCache = false)

    // Метод для подгрузки новых рецептов без кэширования
    suspend fun invokeForMore(): RecipesDto? = repository.getRandomRecipes(skipCache = true)
}