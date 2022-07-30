package com.example.grocery.ui.theme.component

import android.graphics.Color
import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.grocery.ui.theme.gray
import com.example.grocery.ui.theme.lightGray

@Composable
fun Roundedshape(
    modifier: Modifier = Modifier.size(30.dp),
    color: androidx.compose.ui.graphics.Color = MaterialTheme.colors.onPrimary,
    icon: ImageVector,
    onclick: () -> Unit

) {

    Box(modifier = modifier
        .clip(CircleShape)
        .clickable {
            onclick.invoke()
        }
        .background(color = color)
        .border(border = BorderStroke(1.dp, color = lightGray))) {
        Icon(
            icon, contentDescription = "", modifier = Modifier
                .size(20.dp)
                .align(
                    Alignment.Center
                )
        )
    }
}