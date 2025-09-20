package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.StepIngredientNetworkDto
import com.pararam2006.recipesapi.domain.dto.StepIngredientDto

fun StepIngredientNetworkDto.toDomain(): StepIngredientDto {
    return StepIngredientDto(
        id = id ?: 0,
        name = name ?: "",
        localizedName = localizedName ?: "",
        image = image ?: "",
    )
}