package com.example.cocktailapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CockTailApp(modifier: Modifier=Modifier) {
    val viewModel:DataViewModel= viewModel()
    val viewState by viewModel.categoryState.value
LazyColumn(){
    items(viewState.categoryList){
        category ->
    }
}
}
@Composable
fun showCategory(category: category)
{
        Card(onClick = {}
        ){
            Text(text = category.strCategory)
        }
}