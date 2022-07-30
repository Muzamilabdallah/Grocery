package com.example.grocery.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.grocery.R


@Composable
fun appLogo(logoWithBackround: Int) {
    Image(
        painter = painterResource(id =logoWithBackround),
        contentDescription = "",
        modifier = Modifier
            .height(50.dp)
            .width(50.dp)
    )
}