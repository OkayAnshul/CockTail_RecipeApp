package com.example.cocktailapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cocktailapp.ui.theme.CockTailAppTheme
import com.example.cocktailapp.ui.theme.akroniumFamily
import com.example.cocktailapp.ui.theme.aldrichFamily
import com.example.cocktailapp.ui.theme.alegreyaFamily
import com.example.cocktailapp.ui.theme.allertaFamily

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CockTailAppTheme {
                val viewModel:DataViewModel= viewModel()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = { TopAppBar(
                        title = {
                            Text(
                                text ="CockTailRecipeApp",
                                fontFamily = alegreyaFamily,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.ExtraBold
                            )}) }) { innerPadding ->
                   CockTailApp(modifier = Modifier.padding(innerPadding))
//                    DrinkScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
