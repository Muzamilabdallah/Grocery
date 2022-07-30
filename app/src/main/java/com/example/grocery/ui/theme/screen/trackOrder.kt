package com.example.grocery.ui.theme.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grocery.R
import com.example.grocery.ui.theme.*
import com.example.grocery.ui.theme.component.horizontalSpacer
import com.example.grocery.ui.theme.component.veritcalSpacer
import com.example.grocery.ui.theme.screen.destinations.MainScreenDestination
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@Composable
fun trackOrder(navigator: DestinationsNavigator) {
    val singapore = LatLng(15.6569, 32.5486)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }

    Box(modifier = Modifier.fillMaxSize()) {


        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = singapore),
                title = "kharoum bahri",
                snippet = "Marker in bahri"
            )

        }
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = "",
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .padding(vertical = 4.dp, horizontal = 4.dp)
                .clickable {
                    navigator.navigate(MainScreenDestination) {
                        navigator.popBackStack()
                        launchSingleTop = true
                    }
                }
        )

        Card(
            modifier = Modifier
                .aspectRatio(1f)

                .align(Alignment.BottomStart),
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 20.dp, horizontal = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "On the way", style = Typography.h5)

                    val shape = RoundedCornerShape(12.dp)
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .width(100.dp)
                            .clip(shape)
                            .border(BorderStroke(color = lightGray, width = 1.dp))
                            .background(color = MaterialTheme.colors.background)


                    ) {
                        Row(
                            modifier = Modifier.align(Alignment.Center),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Image(
                                painter = painterResource(com.example.grocery.R.drawable.time),
                                contentDescription = "",
                                Modifier.size(20.dp)
                            )
                            horizontalSpacer()
                            Text(text = "10 Min")
                        }
                    }
                }

                veritcalSpacer(20.dp)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {


                    orderStatus("Order placed", listOf(lightgreen, lightgreen))
                    orderStatus("Order on way", listOf(lightgreen, lightGray))
                    orderStatus("Delivered", listOf(darkGray, darkGray))


                }

                veritcalSpacer(30.dp)
                driverInfo()
                veritcalSpacer(20.dp)
                OrderInfoUi("store", "Insta Grocery Store", R.drawable.store)
                veritcalSpacer()
                divider()
                OrderInfoUi("Your place ", "Khartoum Bahri", R.drawable.location)
            }

        }


    }


}

@Composable
fun orderStatus(status: String, color: List<Color>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {


        Text(
            text = status,
            style = Typography.subtitle1.copy(color = color[0], fontWeight = FontWeight.W400)
        )
        veritcalSpacer()
        Divider(
            thickness = 5.dp, modifier = Modifier
                .width(100.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(
                    brush = Brush.horizontalGradient(color)
                )
        )


    }
}

@Composable
fun driverInfo() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,

            ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(color = gray)
            ) {
                Image(
                    painter = painterResource(com.example.grocery.R.drawable.avatar1),
                    contentDescription = "",
                    Modifier
                        .size(40.dp)
                        .align(Alignment.Center)
                )
            }

            horizontalSpacer()

            Column {
                Text(text = "Your deriver hero")
                veritcalSpacer(5.dp)
                Text(
                    text = "Muzamil abdallah",
                    style = Typography.subtitle1.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400
                    )
                )
            }


        }

        contact()
    }
}

@Composable
fun contact() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(color = lightGray)
        ) {
            Image(
                painter = painterResource(R.drawable.message),
                contentDescription = "",
                Modifier
                    .size(30.dp)
                    .align(Center)

            )
        }
        horizontalSpacer()
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(color = lightGray)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_baseline_call_24),
                contentDescription = "",
                Modifier
                    .size(30.dp)
                    .align(Center),
                colorFilter = ColorFilter.tint(
                    color = lightgreen

                ),
            )
        }
    }
}


@Composable
fun OrderInfoUi(title: String, content: String, Icon: Int) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(Icon),
            contentDescription = "",
            Modifier
                .size(50.dp)
                .padding(horizontal = 10.dp)
                .align(CenterVertically)

        )

        horizontalSpacer(5.dp)
        Column() {
            Text(
                text = title,
                style = Typography.subtitle1.copy(color = darkGray, fontWeight = FontWeight.W400)
            )

            Text(
                text = content,
                style = Typography.subtitle1.copy(color = Color.Black, fontWeight = FontWeight.W500)
            )
        }
    }
}

@Composable
fun divider() {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    Canvas(
        Modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {

        drawLine(
            color = darkGray,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }
}

@Preview
@Composable
fun showOrder() {

}