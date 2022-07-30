package com.example.grocery.ui.theme.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.grocery.ui.theme.Typography
import com.example.grocery.ui.theme.lightgreen

@Composable
fun customRoundedButton(text:String, modifier: Modifier=Modifier, color:Color=MaterialTheme.colors.primary, onclicked:()->Unit,) {
    Button(
        onClick = {  onclicked.invoke()},
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = RoundedCornerShape(24.dp),
        modifier = modifier
    ) {
        Text(text = text, style = Typography.button)

    }
}