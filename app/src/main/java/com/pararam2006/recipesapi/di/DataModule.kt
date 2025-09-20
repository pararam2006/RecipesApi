package com.pararam2006.recipesapi.di

import com.pararam2006.recipesapi.data.local.RecipeLocalDataSource
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<Json> {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            prettyPrint = false
        }
    }

    single { RecipeLocalDataSource(androidContext(), get()) }
}