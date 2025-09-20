package com.pararam2006.recipesapi.presentation.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pararam2006.recipesapi.domain.dto.AnalyzedInstructionDto
import com.pararam2006.recipesapi.domain.dto.EquipmentDto
import com.pararam2006.recipesapi.domain.dto.ExtendedIngredientDto
import com.pararam2006.recipesapi.domain.dto.LengthDto
import com.pararam2006.recipesapi.domain.dto.MeasureDto
import com.pararam2006.recipesapi.domain.dto.MeasuresDto
import com.pararam2006.recipesapi.domain.dto.RecipeDto
import com.pararam2006.recipesapi.domain.dto.StepDto
import com.pararam2006.recipesapi.domain.dto.StepIngredientDto
import com.pararam2006.recipesapi.domain.dto.WinePairingDto
import com.pararam2006.recipesapi.domain.usecase.GetRecipesUsecase
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getRecipesUsecase: GetRecipesUsecase
) : ViewModel() {
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

    fun changeInput(newText: String) {
        input = newText
        val newFilteredRecipes = recipes.filter { it.title.contains(input, true) }
        filteredRecipes.clear()
        filteredRecipes.addAll(newFilteredRecipes)
    }

    private suspend fun getRecipes() {
        val res = getRecipesUsecase()
        recipes.clear()
        res?.recipes?.forEach {
            recipes.add(it)
        }
        Log.d("MainScreenViewModel", res.toString())

        getCategories()
        Log.d("MainScreenViewModel", categories.toString())
    }

    //Если выбрана какая-то категория, фильтрует filteredRecipes, если нет - recipes
    private fun filterRecipesByTitle() {
        if (selectedCategory.isNotEmpty()) {
            val filtered = filteredRecipes.filter { it.title.contains(input, true) }
            filteredRecipes.clear()
            filteredRecipes.addAll(filtered)
        } else {
            val filtered = recipes.filter { it.title.contains(input, true) }
            filteredRecipes.clear()
            filteredRecipes.addAll(filtered)
        }

    }

    //Если категория уже выбрана, то отменяет выбор, а если нет - делает его
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
        } else {
            unselectCategory()
            selectedCategory = category
            filterRecipesByCategory()
        }
    }

    private fun unselectCategory() {
        selectedCategory = ""
    }

    init {
        viewModelScope.launch {
            getRecipes()
            filterRecipesByTitle()
            getCategories()
        }
    }
}