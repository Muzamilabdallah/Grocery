package com.example.grocery.ui.theme.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.grocery.R
import com.example.grocery.domain.model.Product
import com.example.grocery.ui.theme.Typography
import com.example.grocery.ui.theme.component.veritcalSpacer
import com.example.grocery.ui.theme.transparent

@Composable
fun productCard(item: Product, modifier: Modifier, vertical: Dp = 10.dp,onItemClicked:()->Unit) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = transparent)

    )
    {
        Column(
            modifier = modifier
        ) {

            Image(
                painter = painterResource(id = item.image),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit

            )

            veritcalSpacer(vertical)
            Text(text = item.name, style = Typography.body1)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
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

                customImageButton(color = MaterialTheme.colors.primary, icon = R.drawable.plus) {
                    onItemClicked.invoke()
                }

            }


        }
    }
}