package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.MeasureNetworkDto
import com.pararam2006.recipesapi.domain.dto.MeasureDto

fun MeasureNetworkDto.toDomain(): MeasureDto {
    return MeasureDto(
        amount = amount ?: 0.0,
        unitLong = unitLong ?: "",
        unitShort = unitShort ?: ""
    )
}