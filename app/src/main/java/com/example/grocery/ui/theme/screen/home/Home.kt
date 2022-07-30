@file:OptIn(ExperimentalPagerApi::class)

package com.example.grocery.ui.theme.screen

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grocery.R
import com.example.grocery.domain.model.CartItem
import com.example.grocery.domain.model.Product
import com.example.grocery.ui.theme.*
import com.example.grocery.ui.theme.component.ShimmerAnimation
import com.example.grocery.ui.theme.component.veritcalSpacer
import com.example.grocery.ui.theme.screen.common.productCard
import com.example.grocery.ui.theme.screen.destinations.productDestination
import com.example.grocery.ui.theme.screen.destinations.productDetailsDestination
import com.example.grocery.ui.theme.screen.home.HomeViewModel
import com.example.grocery.ui.theme.screen.product.ProductViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.talhafaki.composablesweettoast.util.SweetToastUtil


@Destination(start = false)
@Composable
fun Home(navigator: DestinationsNavigator) {
    val homeViewModel = remember {
        HomeViewModel()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.background(color = transparent)) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Row {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .align(Alignment.CenterVertically)
                                .background(lightGray),
                        ) {
                            Image(
                                painter = painterResource(R.drawable.avatar1),
                                contentDescription = "",
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(vertical = 4.dp)
                                    .size(35.dp),
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))

                        Column() {
                            Text(
                                text = "Good morning",
                                style = Typography.body2.copy(
                                    color = gray,

                                    fontWeight = FontWeight.Normal
                                )
                            )
                            Text(text = "Amelia Barlow")

                        }
                    }
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(90.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .align(Alignment.CenterVertically)
                            .background(Color.White),
                    ) {
                        Row(modifier = Modifier.align(Alignment.Center)) {
                            Icon(Icons.Default.LocationOn, "", tint = green)
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(text = "kh")
                        }
                    }
                }

                veritcalSpacer()
                searchField()
                veritcalSpacer()
                imageSlider(homeViewModel)
                veritcalSpacer()


            }

        }
        Box(modifier = Modifier.align(Alignment.Start)) {
            title("Categories")
        }
        category(navigator = navigator, homeViewModel)
        veritcalSpacer()

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .align(Alignment.Start)
                .fillMaxWidth()
        ) {
            title("Best Selling")
            Text(
                text = "See aLL",
                color = MaterialTheme.colors.primary,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }


        bestSellingItems(homeViewModel.state.collectAsState().value, navigator)

    }
}

@Composable
fun searchField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Gray,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        maxLines = 1,
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        placeholder = { Text(text = "Search Category") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                tint = MaterialTheme.colors.primary,
                contentDescription = "Search Icon"
            )
        },

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)

    )

}

@Composable
fun imageSlider(homeViewModel: HomeViewModel) {

    var state = rememberPagerState()

    HorizontalPager(
        state = state,
        count = homeViewModel.bannerList.size, modifier = Modifier
            .height(160.dp)
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) { page ->
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(contentAlignment = Alignment.BottomCenter) {
                Image(
                    painter = painterResource(id = homeViewModel.bannerList[page]),
                    contentDescription = "",
                    Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

            }
        }
    }
}


@Composable
fun title(title: String) {
    Text(
        text = title,
        style = Typography.subtitle2.copy(fontWeight = FontWeight.W500),
        modifier = Modifier.padding(horizontal = 20.dp)
    )

}


@Composable
fun category(navigator: DestinationsNavigator, homeViewModel: HomeViewModel) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,

        ) {
        items(homeViewModel.categorylist) { item ->
            Column {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(color = transparent)
                        .clickable {
                            navigator.navigate(productDestination) {
                                launchSingleTop = true
                            }
                        },
                ) {

                    Image(
                        painter = painterResource(id = item.imageId),
                        contentDescription = "",
                        modifier = Modifier
                            .size(40.dp)
                            .align(
                                Alignment.Center
                            )
                    )

                }
                veritcalSpacer(4.dp)
                Text(
                    text = item.name,
                    style = Typography.body1.copy(fontWeight = FontWeight.W400),
                    modifier = Modifier.align(CenterHorizontally)
                )

            }

        }
    }

}

@Composable
fun bestSellingItems(state: UiState, navigator: DestinationsNavigator) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp / 2.5f
    val productViewModel: ProductViewModel = viewModel()
    var showToast = remember { mutableStateOf(false) }

    when (state) {
        is UiState.LoadingState -> {

            LazyRow(content = {
                items(4) {
                    ShimmerAnimation(
                        modifier = Modifier
                            .height(180.dp)
                            .width(width = screenWidth)
                            .padding(8.dp)
                    )
                }
            })
        }

        is UiState.Loaded -> {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),

                ) {
                items(state.data) { item: Product ->
                    productCard(
                        item,
                        modifier = Modifier
                            .height(180.dp)
                            .width(width = screenWidth)
                            .padding(8.dp)
                            .clickable {
                                navigator.navigate(productDetailsDestination(item)) {
                                    launchSingleTop = true
                                }
                            },

                        ) {
                        productViewModel.addItemToCart(
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

@Preview
@Composable
fun home() {
//    Home()
}