package com.pararam2006.recipesapi.data.local

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.pararam2006.recipesapi.domain.dto.RecipeDto
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import androidx.core.content.edit

class RecipeLocalDataSource(
    private val context: Context,
    private val jsonParser: Json
) {

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    companion object {
        const val PREFS_NAME = "recipe_cache_prefs_file"
        const val KEY_RECIPES_LIST = "cached_recipes_list_json"
        private const val TAG = "RecipeLocalDataSource"
    }

    suspend fun getSavedRecipes(): List<RecipeDto> {
        val jsonString = prefs.getString(KEY_RECIPES_LIST, null)
        return if (jsonString != null) {
            try {
                jsonParser.decodeFromString<List<RecipeDto>>(jsonString)
            } catch (e: SerializationException) {
                Log.e(TAG, "Error decoding recipes from Prefs: ${e.message}")
                clearAllRecipes()
                emptyList()
            } catch (e: Exception) {
                Log.e(TAG, "Unexpected error decoding recipes: ${e.message}")
                emptyList()
            }
        } else {
            emptyList()
        }
    }

    suspend fun saveRecipes(recipes: List<RecipeDto>) {
        try {
            val jsonString = jsonParser.encodeToString(recipes)
            prefs.edit { putString(KEY_RECIPES_LIST, jsonString) }
            Log.d(TAG, "${recipes.size} recipes saved to SharedPreferences.")
        } catch (e: SerializationException) {
            Log.e(TAG, "Error encoding recipes to Prefs: ${e.message}")
        } catch (e: Exception) {
            Log.e(TAG, "Unexpected error encoding recipes: ${e.message}")
        }
    }

    suspend fun clearAllRecipes() {
        prefs.edit { remove(KEY_RECIPES_LIST) }
        Log.d(TAG, "All recipes cleared from SharedPreferences.")
    }
}