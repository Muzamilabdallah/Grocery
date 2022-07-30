package com.example.grocery.ui.theme.uitl

import android.graphics.drawable.Icon
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.grocery.R
import com.example.grocery.ui.theme.screen.destinations.HomeDestination
import com.example.grocery.ui.theme.screen.destinations.cartPageDestination
import com.example.grocery.ui.theme.screen.destinations.settingDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

//enum class Routes(
//    val screen: Screen,
//    @StringRes val label: Int,
//    val icon: ImageVector,
//) {
//    Home(Screen.Home, R.string.home, Icons.Outlined.Home),
//    Cart(Cart, R.string.cart, Icons.Default.ShoppingCart),
//    Setting(Setting, R.string.setting, Icons.Outlined.Settings),
//    Profile(Profile, R.string.profile, Icons.Outlined.Person)
////    object bottomItems { val items = listOf( Home,  Search,Setting) }
//
//}

data class  Route(val id:Screen,val name:String,val icon: ImageVector,var  isSelected:Boolean=false)


val listOfRoutes= mutableListOf(
    Route(Screen.Home,"Home",Icons.Outlined.Home, isSelected = true),
    Route(Screen.Cart,"Cart",Icons.Outlined.ShoppingCart),
    Route(Screen.Setting,"Setting",Icons.Outlined.Settings),
    Route(Screen.Profile,"Profile",Icons.Outlined.Person),
)
enum class Screen {
    Home,
    Cart,
    Setting,
    Profile
}