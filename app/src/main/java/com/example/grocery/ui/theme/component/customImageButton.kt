package com.example.grocery.ui.theme.screen.common

import android.graphics.Color
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.grocery.R


@Composable
fun customImageButton( color :androidx.compose.ui.graphics.Color,icon: Int,onClicked:()->Unit ) {
    Box(
        modifier = Modifier
            .size(30.dp)
            .clip(CircleShape)
            .background(color = color)
            .clickable {  onClicked.invoke() }
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = "",
            modifier = Modifier
                .size(15.dp)
                .align(Alignment.Center)

        )
    }
}