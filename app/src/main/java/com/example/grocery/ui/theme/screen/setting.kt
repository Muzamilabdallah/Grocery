package com.example.grocery.ui.theme.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grocery.ui.theme.component.veritcalSpacer
import com.example.grocery.ui.theme.screen.common.header
import com.example.grocery.ui.theme.screen.destinations.Destination
import com.example.grocery.ui.theme.screen.setting.ThemeViewModel
import com.example.grocery.ui.theme.uitl.ThemeState

@com.ramcosta.composedestinations.annotation.Destination
@Composable
fun setting(      vm: ThemeViewModel = viewModel()) {

    val checkedState = remember { mutableStateOf(true) }
    header(icon = 0, title = "setting") {


    }

    veritcalSpacer()

    Column(modifier = Modifier.padding(20.dp)) {
        Switch(
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = it

                ThemeState.darkModeState.value = it

            }
        )
    }

    // 0111610399

}