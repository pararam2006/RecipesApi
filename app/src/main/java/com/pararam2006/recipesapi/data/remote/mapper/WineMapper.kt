package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.WineNetworkDto
import com.pararam2006.recipesapi.domain.dto.WineDto

fun WineNetworkDto.toDomain() : WineDto {
    return WineDto(
        id = id ?: 0,
        title = title ?: "",
        description = description ?: "",
        price = price ?: "",
        imageUrl = imageUrl ?: "",
        averageRating = averageRating ?: 0.0,
        ratingCount = ratingCount ?: 0.0,
        score = score ?: 0.0,
        link = link ?: ""
    )
}