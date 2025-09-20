package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.RecipeNetworkDto
import com.pararam2006.recipesapi.domain.dto.RecipeDto
import com.pararam2006.recipesapi.domain.dto.WinePairingDto

fun RecipeNetworkDto.toDomain(): RecipeDto {
    return RecipeDto(
        id = id ?: 0,
        title = title ?: "",
        image = image ?: "",
        imageType = imageType ?: "",
        servings = servings ?: 0,
        readyMinutes = readyMinutes ?: 0,
        cookingMinutes = cookingMinutes ?: 0,
        preparationMinutes = preparationMinutes ?: 0,
        aggregateLikes = aggregateLikes ?: 0,
        license = license ?: "",
        sourceName = sourceName ?: "",
        sourceUrl = sourceUrl ?: "",
        spoonacularSourceUrl = spoonacularSourceUrl ?: "",
        healthScore = healthScore ?: 0,
        spoonacularScore = spoonacularScore ?: 0.0,
        pricePerServing = pricePerServing ?: 0.0,
        analyzedInstructions = analyzedInstructions?.mapNotNull { it?.toDomain() } ?: emptyList(),
        cheap = cheap ?: false,
        creditsText = creditsText ?: "",
        cuisines = cuisines?.filterNotNull() ?: emptyList(),
        diets = diets?.filterNotNull() ?: emptyList(),
        gaps = gaps ?: "",
        glutenFree = glutenFree ?: false,
        instructions = instructions ?: "",
        ketogenic = ketogenic ?: false,
        lowFodmap = lowFodmap ?: false,
        occasions = occasions?.filterNotNull() ?: emptyList(),
        sustainable = sustainable ?: false,
        vegan = vegan ?: false,
        vegetarian = vegetarian ?: false,
        veryHealthy = veryHealthy ?: false,
        veryPopular = veryPopular ?: false,
        whole30 = whole30 ?: false,
        weightWatcherSmartPoints = weightWatcherSmartPoints ?: 0,
        dishTypes = dishTypes?.filterNotNull() ?: emptyList(),
        extendedIngredients = extendedIngredients?.mapNotNull { it?.toDomain() } ?: emptyList(),
        summary = summary ?: "",
        winePairing = winePairing?.toDomain() ?: WinePairingDto(
            pairedWines = emptyList(),
            pairedText = "",
            productMatches = emptyList()
        ),
    )
}