package com.example.grocery.ui.theme.screen.cart

import android.content.ClipData
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocery.data.CartRepositoryImpl
import com.example.grocery.domain.model.CartItem
import com.example.grocery.ui.theme.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {

    var quntity = mutableStateOf(0)

    private var _itemList = MutableStateFlow<List<CartItem>>(emptyList())
    val itemList = _itemList.asStateFlow()


    init {
        getCartItem()
    }

    fun getCartItem() {
        _itemList.value = CartRepositoryImpl.cartList
    }

    fun updateItem(index: Int, newQnt: Int) {
        CartRepositoryImpl.updateCartItem(index = index, newQnt)
        getCartItem()

    }


    fun setQuantity(qnt: Int) {
        quntity.value = qnt
    }

    fun addQuentity(qnt: Int) {
        quntity.value = qnt + 1

    }

    fun decreaseQuentity(qnt: Int) {
        if (quntity.value > 0)
            quntity.value = qnt - 1
    }

    fun clearAll() {
        CartRepositoryImpl.deleteALl()
        getCartItem()
    }
}

