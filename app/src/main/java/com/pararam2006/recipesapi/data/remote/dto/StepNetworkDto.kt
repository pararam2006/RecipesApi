package com.pararam2006.recipesapi.data.remote.dto

data class StepNetworkDto(
    val number: Int?,
    val step: String?,
    val ingredients: List<StepIngredientNetworkDto?>?,
    val equipment: List<EquipmentNetworkDto?>?,
    val length: LengthNetworkDto?,
)
