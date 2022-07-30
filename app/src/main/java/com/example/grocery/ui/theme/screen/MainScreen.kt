package com.example.grocery.ui.theme.screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grocery.ui.theme.component.CustomNavigationBar
import com.example.grocery.ui.theme.screen.cart.CartViewModel
import com.example.grocery.ui.theme.screen.cart.cartPage
import com.example.grocery.ui.theme.uitl.Screen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun MainScreen(navigator: DestinationsNavigator) {

    val currentDestination = remember {
        mutableStateOf(Screen.Home)
    }
     val cartViewModel: CartViewModel = viewModel()
    cartViewModel.getCartItem()

    Scaffold(
        content = {
            when (currentDestination.value) {
                Screen.Home -> Home(navigator = navigator)
                Screen.Setting -> setting()
                Screen.Cart -> cartPage(navigator = navigator)
                Screen.Profile -> profile()

            }
        },
        bottomBar = {


            CustomNavigationBar() { id ->
                currentDestination.value = id
            }
        }
    )


}