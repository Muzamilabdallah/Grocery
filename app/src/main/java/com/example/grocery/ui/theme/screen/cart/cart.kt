package com.example.grocery.ui.theme.screen.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grocery.R
import com.example.grocery.domain.model.CartItem
import com.example.grocery.ui.theme.component.veritcalSpacer
import com.example.grocery.ui.theme.component.customRoundedButton
import com.example.grocery.ui.theme.screen.common.header
import com.example.grocery.ui.theme.screen.destinations.MainScreenDestination
import com.example.grocery.ui.theme.screen.destinations.trackOrderDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination()
@Composable
fun cartPage(navigator: DestinationsNavigator) {

    val viewModel: CartViewModel = viewModel()

    Column(modifier = Modifier.fillMaxSize()) {


        header(hasSearch = false, title = "cart", icon = R.drawable.basket) {
            navigator.navigate(MainScreenDestination)
        }
        veritcalSpacer()
        val cartItemlist = viewModel.itemList.collectAsState().value
        if (cartItemlist.isNotEmpty())
            cartList(cartItemlist, Modifier.weight(2f), viewModel)

        Column(modifier = Modifier.weight(0.8f)) {
            customRoundedButton(
                "Continue",
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(50.dp)
            ) {
                navigator.navigate(trackOrderDestination) {
                    navigator.popBackStack()
                    launchSingleTop = true
                    viewModel.clearAll()
                }
            }
        }
    }
}


@Composable
fun cartList(cartItem: List<CartItem>, modifier: Modifier, viewModel: CartViewModel) {
    LazyColumn(modifier) {
        items(cartItem.size) { index ->
            cartItem(cartItem[index], index, viewModel)
            Divider()
        }
    }
}


@Preview
@Composable
fun cartprev() {

//    cartPage()

}