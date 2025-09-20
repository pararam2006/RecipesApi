package com.pararam2006.recipesapi.data.remote.api

import com.pararam2006.recipesapi.data.remote.dto.RecipesNetworkDto
import retrofit2.Response
import retrofit2.http.*


interface RecipesApi {
    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("number") number: Int = 20,
        @Query("apiKey") apiKey: String = "640ad4f250454e5496c95be441becf58",
    ): Response<RecipesNetworkDto>

//    @GET("ingredients_100x100/{image}")
//    suspend fun getIngredientIcon(
//        @Path("image") image: String,
//    ):
}