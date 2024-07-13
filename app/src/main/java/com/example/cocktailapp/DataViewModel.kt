package com.example.cocktailapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataViewModel : ViewModel() {

    private val _categoryState = mutableStateOf(CategoryState())
    val categoryState:State<CategoryState> = _categoryState

    private val _drinkState = mutableStateOf(DrinkState())
    val drinkState:State<DrinkState> = _drinkState
    private val _DrinkDataState = mutableStateOf(DrinkDataState())
    val Data:State<DrinkDataState> =_DrinkDataState

    init {
        fetchCategories()
        //fetchDrinks("Shot")
    }

    fun fetchDrinkData(whichDrink:String){
        viewModelScope.launch {
            try {
             val Drinkdata= Service.getDrinkData(whichDrink)
                _DrinkDataState.value=_DrinkDataState.value.copy(loading = false,
                    error = null,
                    Data=Drinkdata.drinks)
            }catch (e:Exception){
                _DrinkDataState.value=_DrinkDataState.value.copy(loading = false,
                    error = e.message)
            }
        }
    }
    fun fetchCategories() {
        viewModelScope.launch {
            _categoryState.value = _categoryState.value.copy(loading = true)
            try {
                val category = Service.getCategories()
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    categoryList = category.drinks,
                    error = null
                )
            } catch (e: Exception) {
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    error = e.message
                )
            }
        }
    }
    fun fetchDrinks(category: String) {
        viewModelScope.launch {
            _drinkState.value = _drinkState.value.copy(loading = true)
            try {
                val drinks =Service.getDrinks(category)
                _drinkState.value = _drinkState.value.copy(
                    loading = false,
                    drinkList = drinks.drinks,
                    error = null
                )
            } catch (e: Exception) {
                _drinkState.value = _drinkState.value.copy(
                    loading = false,
                    error = e.message
                )
            }
        }
    }
    data class DrinkDataState(
        val loading:Boolean=true,
        val error: String?=null,
        val Data:List<EachDrink> = emptyList()
    )

    data class CategoryState(
        val loading: Boolean = true,
        val categoryList: List<Category> = emptyList(),
        val error: String? = null
    )
    data class DrinkState(
        val loading: Boolean = true,
        val drinkList: List<Drink> = emptyList(),
        val error: String? = null
    )
}
