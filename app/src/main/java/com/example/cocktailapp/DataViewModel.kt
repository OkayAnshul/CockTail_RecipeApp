package com.example.cocktailapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataViewModel:ViewModel() {

    init {
        fetchCategories()
    }
   private val _categoryState = mutableStateOf(CategoryState())
    val categoryState= mutableStateOf(_categoryState)
    fun fetchCategories(){
        viewModelScope.launch {
            _categoryState.value=_categoryState.value.copy(loading = true)
        try {
            val category= recipeService.getCategories()
            _categoryState.value=_categoryState.value.copy(loading = false,
                categoryList = category.drinks,
                error = null)
        } catch(e:Exception)
        {
            _categoryState.value=_categoryState.value.copy(loading = false,
                error =e.message)
        }
        }

    }
    data class CategoryState(val loading:Boolean=true,
                             val categoryList:List<category> = emptyList(),
                             val error: String?=null)
}