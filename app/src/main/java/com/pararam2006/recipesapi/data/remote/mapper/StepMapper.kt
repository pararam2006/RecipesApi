package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.StepNetworkDto
import com.pararam2006.recipesapi.domain.dto.LengthDto
import com.pararam2006.recipesapi.domain.dto.StepDto

fun StepNetworkDto.toDomain(): StepDto {
    return StepDto(
        number = number ?: 0,
        step = step ?: "",
        ingredients = ingredients?.mapNotNull { it?.toDomain() } ?: emptyList(),
        equipment = equipment?.mapNotNull{ it?.toDomain() } ?: emptyList(),
        length = length?.toDomain() ?: LengthDto(
            number = 0,
            unit = "",
        )
    )
}