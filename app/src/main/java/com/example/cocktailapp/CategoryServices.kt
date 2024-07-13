package com.example.cocktailapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val BaseUrl = Retrofit.Builder()
    .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val Service= BaseUrl.create(CategoryServices::class.java)

//val recipeService:CategoryServices= retrofit.create(ApiServices::class.java)

interface CategoryServices {
    @GET("list.php?c=list")
    suspend fun getCategories(): CategoryResponse

    @GET("filter.php")
    suspend fun getDrinks(@Query("c") drinks:String): DrinkCategoryResponse

    @GET("lookup.php")
    suspend fun getDrinkData(@Query("i") DrinkData:String):DrinkDataResponse
}