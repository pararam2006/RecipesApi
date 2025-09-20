package com.pararam2006.recipesapi.data.remote.dto

data class ExtendedIngredientNetworkDto(
    val aisle: String?,
    val amount: Double?,
    val consistency: String?,
    val id: Int?,
    val image: String?,
    val measures: MeasuresNetworkDto?,
    val meta: List<String?>?,
    val name: String?,
    val nameClean: String?,
    val original: String?,
    val originalName: String?,
    val unit: String?,
)
