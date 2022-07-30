package com.example.grocery.ui.theme.screen.product

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grocery.R
import com.example.grocery.domain.model.Product
import com.example.grocery.domain.model.CartItem
import com.example.grocery.ui.theme.Typography
import com.example.grocery.ui.theme.component.horizontalSpacer
import com.example.grocery.ui.theme.component.veritcalSpacer
import com.example.grocery.ui.theme.component.customRoundedButton
import com.example.grocery.ui.theme.lightGray
import com.example.grocery.ui.theme.screen.common.customImageButton
import com.example.grocery.ui.theme.screen.common.header
import com.example.grocery.ui.theme.transparent
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetSuccess


@com.ramcosta.composedestinations.annotation.Destination(start = false)
@Composable
fun productDetails(navigator: DestinationsNavigator, item: Product) {

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.2f)
                .background(color = transparent)
                .clip(RoundedCornerShape(bottomStart = 100.dp, bottomEnd = 100.dp))
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()


            ) {

                header(true, "", 0) {
                    navigator.popBackStack()
                }
                Image(
                    painterResource(item.image),
                    contentDescription = "",
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally)
                )


            }
        }
        veritcalSpacer()
        itemBody(item)
    }
}

@Composable
fun itemBody(item: Product) {

    var showToast = remember { mutableStateOf(false) }
    val viewModel = remember { ProductViewModel() }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(
                text = item.name,
                style = Typography.subtitle1.copy(fontSize = 18.sp, fontWeight = FontWeight.W500)
            )
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                customImageButton(color = transparent, icon = R.drawable.minus) {
                    viewModel.decreaseItem()
                }

                Text(
                    text = "${viewModel.counter.value}",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                horizontalSpacer()
                customImageButton(color = MaterialTheme.colors.primary, icon = R.drawable.plus) {
                    viewModel.increaseItem()

                }
            }
        }
        Row {
            Text(
                text = item.weight,
                style = Typography.body1.copy(color = Color.Red)
            )
            Text(
                text = " ,${item.price}$",
                style = Typography.body1.copy(color = Color.Red)
            )
        }
        veritcalSpacer()
        Text(
            text = "",
            style = Typography.body2,
            modifier = Modifier.padding(end = 12.dp)
        )

        itemDetail()

        veritcalSpacer(20.dp)
        customRoundedButton(
            "Add to cart", modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {

            viewModel.addItemToCart(
                CartItem = CartItem(
                    item.name,
                    item.image,
                    item.weight,
                    item.price,
                    viewModel.counter.value,
                )
            )
            showToast.value = true

        }


    }
    if (showToast.value) {
        SweetSuccess(
            message = "Item Added to cart",
            duration = Toast.LENGTH_SHORT,
            padding = PaddingValues(top = 16.dp),
            contentAlignment = Alignment.TopCenter
        )
        showToast.value = false
    }

}


@Composable
fun rectangleShape(image: Int, title: String, content: String, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .height(70.dp)
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(
                border = BorderStroke(1.5.dp, color = lightGray)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterStart)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                modifier = Modifier.size(30.dp)
            )
            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                Text(
                    text = title,
                    style = Typography.body2.copy(
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.W400
                    )
                )
                Text(text = content, style = Typography.body2)
            }
        }
    }
}

@Composable
fun itemDetail() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
        ) {
            rectangleShape(
                image = R.drawable.lotus, title = "100%",
                content = "Organic",
                modifier = Modifier
                    .weight(1f)

            )
            rectangleShape(
                R.drawable.warnaty,
                title = "1 Year",
                "Expiration",
                modifier = Modifier
                    .weight(1f)

            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
        ) {
            rectangleShape(
                image = R.drawable.favourites,
                "4.3",
                "Reviews",
                modifier = Modifier
                    .weight(1f)

            )
            rectangleShape(
                image = R.drawable.colories,
                "80 kcal",
                "100 Gram",
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp)
            )
        }
    }
}

@Preview
@Composable
fun productDetailPrev() {
//    productDetails(null!!)
}