package com.example.cocktailapp

sealed class Screen(val route: String) {
    object CategoryScreen:Screen("cScreen")
    object DrinksScreen:Screen("dScreen")
    object DrinkDataScreen:Screen("dDScreen")
}