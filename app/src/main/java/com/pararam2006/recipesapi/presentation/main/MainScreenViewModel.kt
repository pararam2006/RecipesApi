package com.pararam2006.recipesapi.presentation.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pararam2006.recipesapi.domain.dto.RecipeDto
import com.pararam2006.recipesapi.domain.usecase.GetRecipesUsecase
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getRecipesUsecase: GetRecipesUsecase
) : ViewModel() {
    val TAG = "MainScreenViewModel"
    var input by mutableStateOf("")
        private set

    //TODO Реализовать кэширование(можно через сохранение последнего списка в БД)
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
        filterRecipesByCategory()
        filterRecipesByTitle()
    }

    private suspend fun getRecipes() {
        val res = getRecipesUsecase()
        recipes.clear()
        res?.recipes?.forEach {
            recipes.add(it)
        }
        Log.d(TAG, res.toString())

        getCategories()
        Log.d(TAG, categories.toString())
    }

    fun getMoreRecipes() {
        if (isLoading) return

        viewModelScope.launch {
            isLoading = true
            try {
                val newRecipes = getRecipesUsecase()
                val newUniqueRecipes = newRecipes?.recipes?.filter { newItem ->
                    recipes.none { existingItem ->
                        existingItem.id == newItem.id
                    }
                }
                recipes.addAll(newUniqueRecipes ?: emptyList())
                getCategories()
                filterRecipesByCategory()
                filterRecipesByTitle()
                Log.d(TAG, "new recipes:  $newRecipes")
            } catch (e: Exception) {
                isLoading = false
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
            filterRecipesByCategory()
            filterRecipesByTitle()
        } else {
            unselectCategory()
            selectedCategory = category
            filterRecipesByCategory()
            filterRecipesByTitle()
        }
    }

    private fun unselectCategory() {
        selectedCategory = ""
    }

    init {
        viewModelScope.launch {
            getRecipes()
            getCategories()
        }
    }
}