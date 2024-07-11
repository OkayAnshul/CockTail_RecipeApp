package com.example.cocktailapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val retrofit=Retrofit.Builder()
    .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService= retrofit.create(ApiServices::class.java)

interface ApiServices{
    @GET("list.php?c=list")
    suspend fun getCategories():CategoryResponse
}