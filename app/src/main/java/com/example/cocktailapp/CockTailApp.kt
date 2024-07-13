package com.example.cocktailapp

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CockTailApp(modifier: Modifier=Modifier)
{

    val navController= rememberNavController()
    Box(modifier = modifier)
    {
        val viewModel:DataViewModel= viewModel()
        NavHost(navController = navController, startDestination = Screen.CategoryScreen.route) {
            composable(Screen.CategoryScreen.route) {
                CategoryScreen(modifier=Modifier,
                    {navController.navigate(Screen.DrinksScreen.route)},
                    viewModel)
            }
            composable(Screen.DrinksScreen.route) {
                DrinkScreen(modifier=Modifier,
                    {
                        navController.navigate(Screen.DrinkDataScreen.route)}
                    ,viewModel)
            }
            composable(Screen.DrinkDataScreen.route){
                DrinkDataScreen(modifier =Modifier,viewModel)
            }
        }
    }
}