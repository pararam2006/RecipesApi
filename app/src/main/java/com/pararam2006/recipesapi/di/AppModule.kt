package com.pararam2006.recipesapi.di

import org.koin.dsl.module

val appModule = module {
    includes(
        dataModule,
        networkModule,
        repositoryModule,
        useCaseModule,
        viewModelModule,
    )
}