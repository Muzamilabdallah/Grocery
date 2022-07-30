package com.example.grocery.ui.theme.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.grocery.R
import com.example.grocery.ui.theme.component.Roundedshape
import com.example.grocery.ui.theme.component.ToolBarTitle
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun header(hasSearch: Boolean = true, title: String = "",icon:Int, onBackclicked: () -> Unit) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = "",
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .clickable {
                    onBackclicked.invoke()

                }
        )

        title?.let { ToolBarTitle(text = it, icon = icon,Modifier.padding(5.dp)) }

        if (hasSearch)
            Roundedshape(
                Modifier.size(40.dp),
                MaterialTheme.colors.onPrimary,
                Icons.Default.Search
            ) {

            }
        else
            Spacer(modifier = Modifier.size(10.dp))


    }

}
