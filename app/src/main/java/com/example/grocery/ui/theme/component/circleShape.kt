package com.example.grocery.ui.theme.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import java.lang.reflect.Modifier


@Composable
fun circleShape(modifier: androidx.compose.ui.Modifier, content: @Composable () -> Unit) {
    Box(modifier = modifier ) {
        content.invoke()
    }

}