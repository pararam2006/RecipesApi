package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.EquipmentNetworkDto
import com.pararam2006.recipesapi.domain.dto.EquipmentDto

fun EquipmentNetworkDto.toDomain(): EquipmentDto {
    return EquipmentDto(
        id = id ?: 0,
        name = name ?: "",
        localizedName = localizedName ?: "",
        image = image ?: "",
    )
}