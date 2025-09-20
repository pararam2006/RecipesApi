package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.RecipesNetworkDto
import com.pararam2006.recipesapi.domain.dto.RecipesDto

fun RecipesNetworkDto.toDomain(): RecipesDto {
    return RecipesDto(
        recipes = recipes?.mapNotNull { it?.toDomain() } ?: emptyList(),
        spoonacularScore = spoonacularScore ?: 0.0,
        pricePerServing = pricePerServing ?: 0.0
    )
}