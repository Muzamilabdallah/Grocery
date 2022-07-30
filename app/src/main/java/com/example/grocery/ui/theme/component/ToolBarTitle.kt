package com.example.grocery.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.grocery.ui.theme.Typography

@Composable
fun ToolBarTitle(text: String, icon: Int,modifier: Modifier= Modifier) {
    Row (Modifier.padding(8.dp)){
        Text(text = text, style = Typography.h5.copy(fontWeight = FontWeight.W400))
        horizontalSpacer(5.dp)
        if (icon != 0)
            Image(painter = painterResource(id = icon), contentDescription = "", modifier = modifier
                .size(15.dp).align(CenterVertically)
                 )
    }
}