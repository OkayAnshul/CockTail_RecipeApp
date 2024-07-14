package com.example.cocktailapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryScreen(modifier: Modifier = Modifier,
                   navToDrink:()->Unit,
                   viewModel: DataViewModel) {
    //val viewModel:DataViewModel= androidx.lifecycle.viewmodel.compose.viewModel()
    val viewState by viewModel.categoryState

    Box(modifier = modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            viewState.error != null -> {
                Text(text = "Error found: ${viewState.error}", Modifier.align(Alignment.Center))
            }
            else -> {
                LazyVerticalGrid(columns =GridCells.Fixed(1),Modifier.fillMaxSize(), state = rememberLazyGridState()) {
                    items(viewState.categoryList) { category ->
                        ShowCategory(category = category,{navToDrink()},viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun ShowCategory(category: Category,
                 navToDrink:()-> Unit,
                 viewModel: DataViewModel) {
    OutlinedCard(
        onClick = {
            navToDrink()
            viewModel.fetchDrinks(category.strCategory)
        },
        modifier = Modifier
            .padding(8.dp)

    ) {
        Text(
            text = category.strCategory,
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp
        )
    }
}
