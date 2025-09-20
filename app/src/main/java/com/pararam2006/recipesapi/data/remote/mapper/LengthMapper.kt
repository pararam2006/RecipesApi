package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.LengthNetworkDto
import com.pararam2006.recipesapi.domain.dto.LengthDto

fun LengthNetworkDto.toDomain(): LengthDto {
    return LengthDto(
        number = number ?: 0,
        unit = unit ?: ""
    )
}