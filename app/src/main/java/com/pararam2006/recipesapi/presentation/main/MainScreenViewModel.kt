package com.pararam2006.recipesapi.presentation.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pararam2006.recipesapi.data.local.RecipeLocalDataSource
import com.pararam2006.recipesapi.domain.dto.RecipeDto
import com.pararam2006.recipesapi.domain.usecase.GetRecipesUsecase
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getRecipesUsecase: GetRecipesUsecase,
    private val localDataSource: RecipeLocalDataSource
) : ViewModel() {
    val TAG = "MainScreenViewModel"
    var input by mutableStateOf("")
        private set

    var recipes = mutableStateListOf<RecipeDto>()

    var filteredRecipes = mutableStateListOf<RecipeDto>()
        private set

    var categories = mutableStateSetOf<String>()
        private set

    var selectedCategory by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun changeInput(newText: String) {
        input = newText
        updateFilteredRecipes()
    }

    // Объединенный метод для обновления отфильтрованного списка
    private fun updateFilteredRecipes() {
        filterRecipesByCategory()
        filterRecipesByTitle()
    }

    private suspend fun getRecipes() {
        val res = getRecipesUsecase()
        if (res != null) {
            recipes.clear()
            res.recipes.forEach {
                recipes.add(it)
            }
            // Сохраняем в SharedPreferences при успешном получении данных из начальной загрузки
            saveRecipesToCache(res.recipes)

            // Важно: обновляем filteredRecipes после загрузки новых данных
            getCategories()
            updateFilteredRecipes()
        }
        Log.d(TAG, res.toString())
    }

    private suspend fun getMoreRecipesFromNetwork() {
        // Используем новый метод с параметром skipCache = true для подгрузки новых рецептов
        val newRecipes = getRecipesUsecase.invokeForMore()
        val newUniqueRecipes = newRecipes?.recipes?.filter { newItem ->
            recipes.none { existingItem ->
                existingItem.id == newItem.id
            }
        }

        if (!newUniqueRecipes.isNullOrEmpty()) {
            recipes.addAll(newUniqueRecipes)
            // Сохраняем обновленный список в кэш
            saveRecipesToCache(recipes.toList())

            // Важно: обновляем filteredRecipes после добавления новых рецептов
            getCategories()
            updateFilteredRecipes()
        }

        Log.d(TAG, "new recipes: $newRecipes")
    }

    private suspend fun loadRecipesFromCache() {
        try {
            val cachedRecipes = localDataSource.getSavedRecipes()
            if (cachedRecipes.isNotEmpty()) {
                recipes.clear()
                recipes.addAll(cachedRecipes)
                Log.d(TAG, "Загружено ${cachedRecipes.size} рецептов из кэша")
                getCategories()
                // Важно: обновляем filteredRecipes после загрузки из кэша
                updateFilteredRecipes()
            } else {
                Log.d(TAG, "Кэш пуст")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Ошибка при загрузке из кэша: ${e.message}")
        }
    }

    private suspend fun saveRecipesToCache(recipesList: List<RecipeDto>) {
        try {
            localDataSource.saveRecipes(recipesList)
            Log.d(TAG, "Рецепты сохранены в кэш")
        } catch (e: Exception) {
            Log.e(TAG, "Ошибка при сохранении в кэш: ${e.message}")
        }
    }

    fun getMoreRecipes() {
        if (isLoading) return

        viewModelScope.launch {
            isLoading = true
            try {
                getMoreRecipesFromNetwork()
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            } finally {
                isLoading = false
            }
        }
    }

    private fun filterRecipesByTitle() {
        if (input.isNotEmpty()) {
            val currentFiltered = ArrayList(filteredRecipes)
            val furtherFiltered = currentFiltered.filter { it.title.contains(input, true) }
            filteredRecipes.clear()
            filteredRecipes.addAll(furtherFiltered)
        }
    }

    private fun filterRecipesByCategory() {
        if (selectedCategory.isNotEmpty()) {
            val filtered = recipes.filter { it.dishTypes.contains(selectedCategory) }
            filteredRecipes.clear()
            filteredRecipes.addAll(filtered)
        } else {
            filteredRecipes.clear()
            filteredRecipes.addAll(recipes)
        }
    }

    private fun getCategories() {
        categories.clear()
        recipes.forEach { recipe ->
            recipe.dishTypes.forEach { dishType ->
                categories.add(dishType)
            }
        }
    }

    fun selectCategory(category: String) {
        if (category == selectedCategory) {
            unselectCategory()
        } else {
            selectedCategory = category
        }
        updateFilteredRecipes()
    }

    private fun unselectCategory() {
        selectedCategory = ""
    }

    fun refreshRecipes() {
        viewModelScope.launch {
            isLoading = true
            try {
                getRecipes()
            } catch (e: Exception) {
                Log.e(TAG, "Ошибка при обновлении рецептов: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    fun clearCache() {
        viewModelScope.launch {
            try {
                localDataSource.clearAllRecipes()
                recipes.clear()
                filteredRecipes.clear()
                categories.clear()
                Log.d(TAG, "Кэш очищен")
            } catch (e: Exception) {
                Log.e(TAG, "Ошибка при очистке кэша: ${e.message}")
            }
        }
    }

    init {
        viewModelScope.launch {
            // Сначала загружаем данные из кэша, если они есть
            loadRecipesFromCache()

            // Затем пытаемся получить свежие данные из сети
            getRecipes()
        }
    }
}