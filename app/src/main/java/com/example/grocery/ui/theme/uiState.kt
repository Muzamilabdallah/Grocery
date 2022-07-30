package com.example.grocery.ui.theme

import com.example.grocery.domain.model.Product

sealed class UiState {
    data class Loaded(val data: List<Product>) : UiState()
    object LoadingState : UiState()
}