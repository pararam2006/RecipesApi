package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.MeasuresNetworkDto
import com.pararam2006.recipesapi.domain.dto.MeasureDto
import com.pararam2006.recipesapi.domain.dto.MeasuresDto

fun MeasuresNetworkDto.toDomain(): MeasuresDto {
    return MeasuresDto(
        metric = metric?.toDomain() ?: MeasureDto(
            amount = 0.0,
            unitLong = "",
            unitShort = ""
        ),
        us = us?.toDomain() ?: MeasureDto(
            amount = 0.0,
            unitLong = "",
            unitShort = ""
        ),
    )
}