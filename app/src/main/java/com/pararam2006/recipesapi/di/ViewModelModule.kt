package com.pararam2006.recipesapi.di

import com.pararam2006.recipesapi.presentation.main.MainScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MainScreenViewModel)
}