package com.example.grocery.ui.theme.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grocery.R
import com.example.grocery.ui.theme.screen.cart.CartViewModel
import com.example.grocery.ui.theme.uitl.Route

import com.example.grocery.ui.theme.uitl.Screen
import com.example.grocery.ui.theme.uitl.listOfRoutes


@Composable
fun CustomNavigationBar(
    onClick: (id: Screen) -> Unit
) {

    var currentDestination = remember {
        mutableStateOf(Screen.Home)
    }
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = CenterVertically
    ) {
        listOfRoutes.forEach { item ->
            BottomNavigationItems(item, currentDestination) {
                currentDestination.value == it
                onClick.invoke(it)
            }
            // item.isSelected = false
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavigationItems(
    item: Route,
    currentDestination: MutableState<Screen>,
    vm: CartViewModel= viewModel(),
    onClick: (id: Screen) -> Unit
) {
    val backround =
        if (currentDestination.value == item.id) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor =
        if (currentDestination.value == item.id) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)

            .padding(8.dp)
            .clickable {
                currentDestination.value = item.id
                onClick(item.id)
            },

        ) {


        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Column() {
                if (item.id == Screen.Cart) {

                    Box() {
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clip(CircleShape)
                                .padding(bottom = 6.dp)
                                .align(TopCenter)
                                .background(color = MaterialTheme.colors.primary)

                        ) {
                            Image(
                                painter = painterResource(R.drawable.cart),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(25.dp)
                                    .align(Center)
                            )

                        }


                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape)
                                .align(BottomCenter)
                                .background(color = Color.Red)

                        ) {
                            Text(
                                text = "${vm.itemList.collectAsState().value.size}",
                                color = MaterialTheme.colors.background,
                                modifier = Modifier.align(
                                    Center
                                )
                            )
                        }
                    }
                } else {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null,
                        tint = contentColor
                    )
                    AnimatedVisibility(visible = currentDestination.value == item.id) {
                        Text(
                            text = item.name,
                            color = contentColor
                        )
                    }
                }

            }


        }
    }

}







