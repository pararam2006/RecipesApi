package com.pararam2006.recipesapi.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.pararam2006.recipesapi.data.local.RecipeLocalDataSource
import com.pararam2006.recipesapi.data.remote.api.RecipesApi
import com.pararam2006.recipesapi.data.remote.dto.RecipesNetworkDto
import com.pararam2006.recipesapi.data.remote.mapper.toDomain
import com.pararam2006.recipesapi.domain.dto.RecipesDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RecipeRepository(
    private val api: RecipesApi,
    private val localDataSource: RecipeLocalDataSource,
    private val context: Context
) {

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }

    suspend fun getRandomRecipes(skipCache: Boolean = false): RecipesDto? = withContext(Dispatchers.IO) {
        if (isNetworkAvailable()) {
            // Есть интернет - загружаем из сети
            try {
                val response: Response<RecipesNetworkDto> = api.getRandomRecipes()
                Log.i("RecipeRepository", "Response code: ${response.code()}")

                when (response.code()) {
                    200 -> {
                        Log.i("RecipeRepository", "Данные успешно загружены из сети")
                        val recipesDto = response.body()?.toDomain()

                        // Сохраняем в кэш только если это первоначальная загрузка (не skipCache)
                        if (!skipCache) {
                            recipesDto?.recipes?.let { recipes ->
                                localDataSource.saveRecipes(recipes)
                                Log.d("RecipeRepository", "Данные сохранены в кэш")
                            }
                        }

                        return@withContext recipesDto
                    }
                    401 -> {
                        Log.w("RecipeRepository", "Ошибка авторизации")
                        return@withContext if (skipCache) null else getCachedRecipes()
                    }
                    402 -> {
                        Log.w("RecipeRepository", "Достигнут лимит запросов API")
                        return@withContext if (skipCache) null else getCachedRecipes()
                    }
                    404 -> {
                        Log.w("RecipeRepository", "Неправильный запрос")
                        return@withContext if (skipCache) null else getCachedRecipes()
                    }
                    500 -> {
                        Log.e("RecipeRepository", "Ошибка сервера")
                        return@withContext if (skipCache) null else getCachedRecipes()
                    }
                    else -> {
                        Log.w("RecipeRepository", "Необработанная ошибка: ${response.code()}")
                        return@withContext if (skipCache) null else getCachedRecipes()
                    }
                }
            } catch (e: Exception) {
                Log.e("RecipeRepository", "Ошибка сети: ${e.message}")
                return@withContext if (skipCache) null else getCachedRecipes()
            }
        } else {
            // Нет интернета
            if (skipCache) {
                Log.i("RecipeRepository", "Нет интернета для загрузки новых рецептов")
                return@withContext null
            } else {
                Log.i("RecipeRepository", "Нет интернет-соединения, загружаем из кэша")
                return@withContext getCachedRecipes()
            }
        }
    }

    private suspend fun getCachedRecipes(): RecipesDto? {
        val cachedRecipes = localDataSource.getSavedRecipes()
        return if (cachedRecipes.isNotEmpty()) {
            Log.d("RecipeRepository", "Загружено ${cachedRecipes.size} рецептов из кэша")
            RecipesDto(recipes = cachedRecipes)
        } else {
            Log.w("RecipeRepository", "Кэш пуст")
            null
        }
    }

    suspend fun clearCache() {
        localDataSource.clearAllRecipes()
    }
}