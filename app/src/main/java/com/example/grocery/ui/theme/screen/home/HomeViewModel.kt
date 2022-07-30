package com.example.grocery.ui.theme.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocery.data.FakeDataReposirory
import com.example.grocery.domain.model.Category
import com.example.grocery.domain.model.Product
import com.example.grocery.ui.theme.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    var bannerList: List<Int> by mutableStateOf(listOf())
    var categorylist: List<Category> by mutableStateOf(listOf())
    private val _state = MutableStateFlow<UiState>(UiState.LoadingState)
    val state = _state.asStateFlow()

    init {
        bannerList = FakeDataReposirory.getBanner()
        categorylist = FakeDataReposirory.getCategories()
        bestSelling()
    }


    fun bestSelling() {
        viewModelScope.launch {
            delay(2000)
            val bestSelling = FakeDataReposirory.getBestSellingItems()
            _state.value = UiState.Loaded(bestSelling)

        }
    }


}