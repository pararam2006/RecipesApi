package com.pararam2006.recipesapi.di

import com.pararam2006.recipesapi.domain.usecase.GetRecipesUsecase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::GetRecipesUsecase)
}