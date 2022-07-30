package com.example.grocery.ui.theme.screen.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.grocery.R
import com.example.grocery.domain.model.CartItem
import com.example.grocery.ui.theme.Typography
import com.example.grocery.ui.theme.component.horizontalSpacer
import com.example.grocery.ui.theme.component.veritcalSpacer
import com.example.grocery.ui.theme.screen.common.customImageButton
import com.example.grocery.ui.theme.transparent

@Composable
fun cartItem(item: CartItem, index: Int, viewModel: CartViewModel) {

    viewModel.setQuantity(item.qnt)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {


        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(item.image),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
            horizontalSpacer()
            Column(Modifier.padding(8.dp)) {
                Text(text = item.name, style = Typography.h5.copy(fontWeight = FontWeight.W500))
                veritcalSpacer(6.dp)
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
            }
        }

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            customImageButton(color = transparent, icon = R.drawable.minus) {
                viewModel.decreaseQuentity(item.qnt)
                viewModel.updateItem(index, item.qnt--)
            }
            Text(
                text =  "${viewModel.quntity.value}",
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            customImageButton(color = MaterialTheme.colors.primary, icon = R.drawable.plus) {
                viewModel.addQuentity(item.qnt)
                viewModel.updateItem(index, item.qnt++)
            }
        }


    }
}
