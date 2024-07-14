package com.example.cocktailapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cocktailapp.ui.theme.aldrichFamily

@Composable
fun DrinkScreen(
    modifier: Modifier = Modifier,
    navToDrinkData: () -> Unit,
    viewModel: DataViewModel
)
{
   // val viewmodel:DataViewModel= viewModel()
    val viewState by viewModel.drinkState
    Box(){


        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text(text = "Error",
                    modifier = Modifier.align(Alignment.Center))
            }

            else -> {
                LazyVerticalGrid(columns = GridCells.Fixed(2), modifier.fillMaxSize()) {
                    items(viewState.drinkList){
                        drink->
                            ShowDrink(drink,viewModel) {
                                navToDrinkData()
                            }
                    }
                    }
                }
            }
        }
    }
@Composable
fun ShowDrink(drink: Drink, viewModel: DataViewModel, navToDrinkData:()->Unit) {
    OutlinedCard(onClick = {
        viewModel.fetchDrinkData(drink.idDrink)
        navToDrinkData()},colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp)),
        border = BorderStroke(1.dp, Color.Gray)
    ){
        Column {
            Image(
                painter = rememberAsyncImagePainter(drink.strDrinkThumb),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)
                    .padding(16.dp)
                    .aspectRatio(1f)
                    .clip(
                        RoundedCornerShape(8)
                    )
            )
                Text(
                    text = drink.strDrink,
                    fontFamily = aldrichFamily,
                    fontWeight = FontWeight.Thin,
                    softWrap = true,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }
}