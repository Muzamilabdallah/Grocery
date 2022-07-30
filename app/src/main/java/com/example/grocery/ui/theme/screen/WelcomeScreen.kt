package com.example.grocery.ui.theme.screen

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grocery.R
import com.example.grocery.ui.theme.Typography
import com.example.grocery.ui.theme.component.appLogo
import com.example.grocery.ui.theme.component.customRoundedButton
import com.example.grocery.ui.theme.lightgreen
import com.example.grocery.ui.theme.screen.destinations.SignInDestination
import com.google.accompanist.systemuicontroller.rememberSystemUiController

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalAnimationApi::class)
@Destination()
@Composable
fun Welcome(navigator: DestinationsNavigator) {
    var showAnim by remember { mutableStateOf(true) }


    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.isStatusBarVisible = false
    }

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = lightgreen.copy(alpha = 0.02F)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = painterResource(id = R.drawable.brand),
                    contentDescription = "",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )

            }
            appLogo(R.drawable.logo)

            Spacer(modifier = Modifier.padding(vertical = 12.dp))


                Text(
                    text = "    Get your groceies \n delivered to  your home",
                    style = Typography.h5
                )

                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    text = "The best delivery app in town for \n  delivering your daily fresh groceries ",
                    style = Typography.body2,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )


            Spacer(modifier = Modifier.padding(vertical = 8.dp))

            customRoundedButton(text = "Shop now",Modifier.height(40.dp).width(  150.dp ) ,color = MaterialTheme.colors.primary) {
                navigator.navigate(SignInDestination) {
                    launchSingleTop = true
                    navigator.popBackStack()
                }
            }


        }


        Image(
            painter = painterResource(id = R.drawable.fruit),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillBounds
        )
    }
}


@Preview
@Composable
fun prevWelcome() {
    // Welcome()
}