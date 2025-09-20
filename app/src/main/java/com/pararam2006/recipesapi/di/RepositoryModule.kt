package com.pararam2006.recipesapi.di

import com.pararam2006.recipesapi.data.repository.RecipeRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::RecipeRepository)
}