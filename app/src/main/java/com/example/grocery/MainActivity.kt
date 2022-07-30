package com.example.grocery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grocery.ui.theme.GroceryTheme
import com.example.grocery.ui.theme.screen.NavGraphs
import com.example.grocery.ui.theme.screen.destinations.HomeDestination
import com.example.grocery.ui.theme.screen.destinations.MainScreenDestination
import com.example.grocery.ui.theme.screen.destinations.splashScreenDestination
import com.example.grocery.ui.theme.screen.setting.ThemeViewModel
import com.example.grocery.ui.theme.uitl.ThemeState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.rememberNavHostEngine

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val themeViewModel: ThemeViewModel = viewModel()
            val isDark = ThemeState.darkModeState.value
            val isdarkTheme: Boolean by themeViewModel.isDark.observeAsState(false)
            GroceryTheme(darkTheme = isDark) {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val engine = rememberNavHostEngine()
                    val navigator = engine.rememberNavController()
                    DestinationsNavHost(
                        engine = engine,
                        navController = navigator,
                        navGraph = NavGraphs.root,
                        startRoute = splashScreenDestination
                    )

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GroceryTheme {

    }
}