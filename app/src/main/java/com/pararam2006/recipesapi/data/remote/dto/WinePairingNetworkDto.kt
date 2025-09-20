package com.pararam2006.recipesapi.data.remote.dto

data class WinePairingNetworkDto(
    val pairedWines: List<String?>?,
    val pairedText: String?,
    val productMatches: List<WineNetworkDto?>?
)
