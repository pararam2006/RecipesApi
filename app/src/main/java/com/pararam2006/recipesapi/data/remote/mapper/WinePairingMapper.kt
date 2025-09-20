package com.pararam2006.recipesapi.data.remote.mapper

import com.pararam2006.recipesapi.data.remote.dto.WinePairingNetworkDto
import com.pararam2006.recipesapi.domain.dto.WinePairingDto

fun WinePairingNetworkDto.toDomain(): WinePairingDto {
    return WinePairingDto(
        pairedWines = pairedWines?.filterNotNull() ?: emptyList(),
        pairedText = pairedText ?: "",
        productMatches = productMatches?.mapNotNull{ it?.toDomain() } ?: emptyList(),
    )
}