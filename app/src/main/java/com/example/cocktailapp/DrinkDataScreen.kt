package com.example.cocktailapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DrinkDataScreen(modifier: Modifier = Modifier, viewModel: DataViewModel = viewModel()) {
    val viewState = viewModel.Data.value

    Box(modifier = modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            viewState.error != null -> {
                Text(text = "Error", modifier = Modifier.align(Alignment.Center))
            }
            else -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(viewState.Data) { eachDrink ->
                        ShowDrinkData(eachDrink)
                    }
                }
            }
        }
    }
}

@Composable
fun ShowDrinkData(eachDrink: EachDrink) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp)),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = eachDrink.strDrink,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Image(
                painter = rememberAsyncImagePainter(eachDrink.strDrinkThumb),
                contentDescription = eachDrink.strDrink,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Category: ${eachDrink.strCategory}",
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Glass: ${eachDrink.strGlass}",
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Instructions: ${eachDrink.strInstructions}",
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Ingredients:",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            eachDrink.strIngredient1?.let { eachDrink.strMeasure1?.let { it1 ->
                IngredientItem(it,
                    it1
                )
            } }
            eachDrink.strIngredient2?.let { eachDrink.strMeasure2?.let { it1 ->
                IngredientItem(it,
                    it1
                )
            } }
            eachDrink.strIngredient3?.let { eachDrink.strMeasure3?.let { it1 ->
                IngredientItem(it,
                    it1
                )
            } }
            eachDrink.strIngredient4?.let { eachDrink.strMeasure4?.let { it1 ->
                IngredientItem(it,
                    it1
                )
            } }
            eachDrink.strIngredient5?.let { IngredientItem(it.toString(), eachDrink.strMeasure5.toString()) }
            eachDrink.strIngredient6?.let { eachDrink.strMeasure6?.let { it1 -> IngredientItem(it.toString(),
                it1.toString()
            ) } }
            eachDrink.strIngredient7?.let { eachDrink.strMeasure7?.let { it1 -> IngredientItem(
                it.toString(),
                it1.toString()
            ) } }
            eachDrink.strIngredient8?.let { eachDrink.strMeasure8?.let { it1 -> IngredientItem(it.toString(),
                it1.toString()
            ) } }
            eachDrink.strIngredient9?.let { eachDrink.strMeasure9?.let { it1 -> IngredientItem(it.toString(),
                it1.toString()
            ) } }
            eachDrink.strIngredient10?.let { eachDrink.strMeasure10?.let { it1 -> IngredientItem(
                it.toString(),
                it1.toString()
            ) } }
            eachDrink.strIngredient11?.let { eachDrink.strMeasure11?.let { it1 -> IngredientItem(it.toString(),
                it1.toString()
            ) } }
            eachDrink.strIngredient12?.let { eachDrink.strMeasure12?.let { it1 -> IngredientItem(
                it.toString(),
                it1.toString()
            ) } }
            eachDrink.strIngredient13?.let { eachDrink.strMeasure13?.let { it1 -> IngredientItem(it.toString(),
                it1.toString()
            ) } }
            eachDrink.strIngredient14?.let { eachDrink.strMeasure14?.let { it1 -> IngredientItem(it.toString(),
                it1.toString()
            ) } }
            eachDrink.strIngredient15?.let { eachDrink.strMeasure15?.let { it1 -> IngredientItem(it.toString(),
                it1.toString()
            ) } }
//            eachDrink.strIngredient16?.let { eachDrink.strMeasure16?.let { it1 -> IngredientItem(it, it1) } }
//            eachDrink.strIngredient17?.let { eachDrink.strMeasure17?.let { it1 -> IngredientItem(it, it1) } }
//            eachDrink.strIngredient18?.let { eachDrink.strMeasure18?.let { it1 -> IngredientItem(it, it1) } }
//            eachDrink.strIngredient19?.let { eachDrink.strMeasure19?.let { it1 -> IngredientItem(it, it1) } }
//            eachDrink.strIngredient20?.let { eachDrink.strMeasure20?.let { it1 -> IngredientItem(it, it1) } }

            Text(
                text = "Alcoholic: ${eachDrink.strAlcoholic}",
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Text(
                text = "Creative Commons Confirmed: ${eachDrink.strCreativeCommonsConfirmed}",
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Text(
                text = "Date Modified: ${eachDrink.dateModified}",
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}

@Composable
fun IngredientItem(ingredient: String, measure: String) {
    Text(
        text = "$ingredient - $measure",
        modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
    )
}
