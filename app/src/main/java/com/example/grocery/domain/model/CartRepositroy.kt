package com.example.grocery.domain.model

import java.util.concurrent.Flow

interface CartRepositroy {

    fun addItem(product: CartItem)
    fun updateCartItem(index: Int, newQnt: Int)
    fun deleteALl()
}