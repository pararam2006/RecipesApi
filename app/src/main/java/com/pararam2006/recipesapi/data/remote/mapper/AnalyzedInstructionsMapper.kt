package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.AnalyzedInstructionNetworkDto
import com.pararam2006.recipesapi.domain.dto.AnalyzedInstructionDto

fun AnalyzedInstructionNetworkDto.toDomain(): AnalyzedInstructionDto {
    return AnalyzedInstructionDto(
        name = name ?: "",
        steps = steps?.mapNotNull { it?.toDomain() } ?: emptyList(),
        spoonacularScore = spoonacularScore ?: 0.0,
        spoonacularSourceUrl = spoonacularSourceUrl ?: ""
    )
}