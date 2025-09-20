package com.pararam2006.recipesapi.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class LengthDto(
    val number: Int,
    val unit: String,
)