package com.pararam2006.recipesapi.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class EquipmentDto(
    val id: Int,
    val name: String,
    val localizedName: String,
    val image: String,
)