package com.pararam2006.recipesapi.data.remote.repository

import android.util.Log
import com.pararam2006.recipesapi.data.remote.api.RecipesApi
import com.pararam2006.recipesapi.data.remote.dto.RecipesNetworkDto
import com.pararam2006.recipesapi.data.remote.mapper.toDomain
import com.pararam2006.recipesapi.domain.dto.RecipesDto
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class RecipeRepository(
    private val api: RecipesApi
) {
    suspend fun getRandomRecipes(): RecipesDto? = with(Dispatchers.IO) {
        try {
            val response: Response<RecipesNetworkDto> = api.getRandomRecipes()
            Log.i("RecipeRepository", "${response.code()}")
            when (response.code()) {
                200 -> { //OK
                    Log.i("RecipeRepository", "Все хорошо")
                    return response.body()?.toDomain()
                }
                401 -> { //Unauthorized
                    Log.w("RecipeRepository", "Какая-то шляпа с токеном")
                    return null
                }
                402 -> { //Payment Required (достигнут лимит запросов к API)
                    Log.w("RecipeRepository", "Достигнут лимит запросов для API")
                    return null
                }
                404 -> { //Not Found
                    Log.w("RecipeRepository", "Неправильный запрос")
                    return null
                }
                500 -> { //Internal Server Error
                    Log.e("RecipeRepository", "Ошибка сервера")
                    return null
                }
                else -> {
                    Log.w("RecipeRepository", "Необработанная ошибка")
                    return null
                }
            }
        } catch (e: Exception) {
            Log.e("RecipeRepository", "Ошибка: ${e.message}")
            return null
        }
    }
}