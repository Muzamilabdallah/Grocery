package com.example.grocery.ui.theme.screen.product

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocery.data.CartRepositoryImpl
import com.example.grocery.data.FakeDataReposirory
import com.example.grocery.domain.model.CartItem
import com.example.grocery.ui.theme.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {


    private val _state = MutableStateFlow<UiState>(UiState.LoadingState)
    val state = _state.asStateFlow()

    init {

        getProduct()
    }


    fun getProduct() {
        viewModelScope.launch {
            delay(2000)
            val items = FakeDataReposirory.getProductsByCategory()
            _state.value = UiState.Loaded(items)
        }

    }

    val counter = mutableStateOf(1)

    fun increaseItem() {
        counter.value++
    }

    fun decreaseItem() {
        if (counter.value > 0)
            counter.value--
    }


    fun addItemToCart(CartItem: CartItem) {
        CartRepositoryImpl.addItem(CartItem)
    }

}