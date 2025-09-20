package com.pararam2006.recipesapi.data.remote.api

import com.pararam2006.recipesapi.data.remote.dto.RecipesNetworkDto
import retrofit2.Response
import retrofit2.http.*


interface RecipesApi {
    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("number") number: Int = 20,
        @Query("apiKey") apiKey: String = "ff91fa9b029c48dbab1b920baf682d8e",
    ): Response<RecipesNetworkDto>
}