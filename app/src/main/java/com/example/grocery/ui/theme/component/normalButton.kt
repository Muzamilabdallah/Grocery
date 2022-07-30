package com.example.grocery.ui.theme.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.grocery.ui.theme.Typography
import com.example.grocery.ui.theme.lightgreen

@Composable
fun normalButton(
    text: String,
    color: Color = Color.White,
    horizontal: Dp = 0.dp,
    onclicked: () -> Unit,
) {
    Button(
        onClick = { onclicked.invoke() },
        colors = ButtonDefaults.buttonColors(backgroundColor = lightgreen),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .height(50.dp).fillMaxWidth()
            .padding(horizontal = horizontal)
    ) {
        Text(text = text, style = Typography.button.copy(color = color))

    }
}