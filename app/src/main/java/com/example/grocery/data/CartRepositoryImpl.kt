package com.example.grocery.data

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import com.example.grocery.domain.model.CartRepositroy
import com.example.grocery.domain.model.CartItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object CartRepositoryImpl : CartRepositroy {

    var cartList = mutableListOf<CartItem>()

    override fun addItem(product: CartItem) {
        if (cartList.contains(product).not()) {
            var item = cartList.filter { it.name.equals(product.name) }.map {
                it.qnt = it.qnt + product.qnt
            }
            if (item.isEmpty())
                cartList.add(product)

        }
    }


    override fun updateCartItem(index: Int, newQnt: Int) {
        cartList[index] = cartList[index].copy(qnt = newQnt)

    }

    override fun deleteALl() {
        cartList.clear()
    }

}