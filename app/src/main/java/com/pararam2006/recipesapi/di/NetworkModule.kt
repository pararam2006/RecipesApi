package com.pararam2006.recipesapi.di

import com.pararam2006.recipesapi.data.remote.api.RecipesApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    single { get<Retrofit>().create(RecipesApi::class.java) }
    single { OkHttpClient() }
}