package com.example.grocery.ui.theme.screen.product

import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grocery.domain.model.CartItem
import com.example.grocery.ui.theme.UiState
import com.example.grocery.ui.theme.component.*
import com.example.grocery.ui.theme.screen.common.header
import com.example.grocery.ui.theme.screen.common.productCard
import com.example.grocery.ui.theme.screen.destinations.productDetailsDestination

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.talhafaki.composablesweettoast.util.SweetToastUtil


@Destination(start = false)
@Composable
fun product(navigator: DestinationsNavigator?) {
    val viewModel: ProductViewModel = viewModel()
    Column {
        header(title = "Vegeteables", icon = com.example.grocery.R.drawable.vegatable) {
            navigator?.popBackStack()
        }
        veritcalSpacer()

        items(navigator, viewModel.state.collectAsState().value, viewModel)

    }

}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun items(navigator: DestinationsNavigator?, state: UiState, viewModel: ProductViewModel) {
    var showToast = remember { mutableStateOf(false) }
    when (state) {

        is UiState.LoadingState -> {
            loadingShimmer()
        }

        is UiState.Loaded -> {
            LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                items(state.data.size) { index ->

                    productCard(
                        state.data[index], modifier = Modifier
                            .height(200.dp)
                            .padding(8.dp)
                            .fillMaxWidth()
                            .clickable {
                                navigator?.navigate(productDetailsDestination(state.data[index]))
                            },
                        30.dp
                    ) {

                        var item = state.data[index]
                        viewModel.addItemToCart(
                            CartItem = CartItem(
                                item.name,
                                item.image,
                                item.weight,
                                item.price,
                                qnt = 1,
                            )
                        )

                    }
                }
            }
            )
        }
    }

    if (showToast.value) {
        SweetToastUtil.SweetSuccess(
            message = "Item Added to cart",
            duration = Toast.LENGTH_SHORT,
            padding = PaddingValues(top = 16.dp),
            contentAlignment = Alignment.TopCenter
        )
        showToast.value = false
    }
}


@Composable
fun loadingShimmer() {
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(10) { text ->
            ShimmerAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    })

}


@Composable
@Preview
fun productPrev() {


    product(null)
}





