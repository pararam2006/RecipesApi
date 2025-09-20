package com.pararam2006.recipesapi.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class WineDto(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val imageUrl: String,
    val averageRating: Double,
    val ratingCount: Double,
    val score: Double,
    val link: String,
)