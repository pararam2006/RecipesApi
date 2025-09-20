package com.pararam2006.recipesapi.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class WinePairingDto(
    val pairedWines: List<String>,
    val pairedText: String,
    val productMatches: List<WineDto>
)
