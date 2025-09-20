package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.ExtendedIngredientNetworkDto
import com.pararam2006.recipesapi.domain.dto.ExtendedIngredientDto
import com.pararam2006.recipesapi.domain.dto.MeasureDto
import com.pararam2006.recipesapi.domain.dto.MeasuresDto

fun ExtendedIngredientNetworkDto.toDomain(): ExtendedIngredientDto {
    return ExtendedIngredientDto(
        aisle = aisle ?: "",
        amount = amount ?: 0.0,
        consistency = consistency ?: "",
        id = id ?: 0,
        image = image ?: "",
        measures = measures?.toDomain() ?: MeasuresDto(
            metric = MeasureDto(
                amount = 0.0,
                unitLong = "",
                unitShort = ""
            ),
            us = MeasureDto(
                amount = 0.0,
                unitLong = "",
                unitShort = ""
            ),
        ),
        meta = meta?.filterNotNull() ?: emptyList(),
        name = name ?: "",
        nameClean = nameClean ?: "",
        original = original ?: "",
        originalName = originalName ?: "",
        unit = unit ?: "",
    )
}