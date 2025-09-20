package com.pararam2006.recipesapi.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class ExtendedIngredientDto(
    val aisle: String,
    val amount: Double,
    val consistency: String,
    val id: Int,
    val image: String,
    val measures: MeasuresDto,
    val meta: List<String>,
    val name: String,
    val nameClean: String,
    val original: String,
    val originalName: String,
    val unit: String,
)
