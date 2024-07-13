package com.example.cocktailapp



data class DrinkCategoryResponse(val drinks:List<Drink>)

data class Drink(val strDrink:String,
    val strDrinkThumb:String,
    val idDrink:String)
