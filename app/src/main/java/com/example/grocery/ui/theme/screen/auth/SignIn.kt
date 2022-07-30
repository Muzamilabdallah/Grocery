package com.example.grocery.ui.theme.screen.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grocery.R
import com.example.grocery.ui.theme.Typography
import com.example.grocery.ui.theme.component.appLogo
import com.example.grocery.ui.theme.component.normalButton
import com.example.grocery.ui.theme.screen.destinations.HomeDestination
import com.example.grocery.ui.theme.screen.destinations.MainScreenDestination
import com.example.grocery.ui.theme.screen.destinations.WelcomeDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.rememberNavHostEngine


@Destination
@Composable
fun SignIn(navigator: DestinationsNavigator) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {


            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(R.drawable.back),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .height(40.dp)
                        .width(30.dp)
                        .clickable {
                            navigator.navigate(WelcomeDestination) {
                                navigator.popBackStack()
                                launchSingleTop = true
                            }
                        })
            }

            appLogo(R.drawable.logo_with_backround)
            Spacer(Modifier.height(10.dp))
            Text(text = "  Enter your mobile \n          number", style = Typography.h5)
            Spacer(Modifier.height(10.dp))
            Text(text = "we will send you verification code", style = Typography.body2)
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                textInputfield()
            }
            Spacer(Modifier.height(30.dp))
            normalButton("continue") {
                navigator.navigate(MainScreenDestination) {
                    navigator.popBackStack()
                    launchSingleTop = true
                }
            }
            appTerms()

        }
    }

}

private const val TAG = "ANNOTATION_TAG_URL"

@Composable
fun appTerms() {

    val annotatedText = attachLink(
        source = "terms of use",
        segment = "terms of use",
        ""
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(text = "By clicking to on continue you are agreeing     ")

    Row {
        Text(text = " to our service  ")

        ClickableText(text = annotatedText, onClick = {})
    }
//
}

@Composable
fun textInputfield() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = text,

        onValueChange = {
            text = it
        },

        leadingIcon =
        {
            Text(
                text = "+44|",
                style = Typography.h6,
                color = Color.Black,
                modifier = Modifier.padding(start = 24.dp, end = 2.dp, bottom = 4.dp)
            )
        },

        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Gray,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        placeholder = { Text("(000) 000 -00-00") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}


@Preview
@Composable
fun prevSignIn() {
    val engine = rememberNavHostEngine()
//    SignIn()

}

fun attachLink(
    source: String,
    segment: String,
    link: String
): AnnotatedString {
    val builder = AnnotatedString.Builder() // builder to attach metadata(link)
    builder.append(source) // load current text into the builder

    val start = source.indexOf(segment) // get the start of the span "my website"
    val end = start + segment.length // get the end of the span
    val hyperlinkStyle = SpanStyle(
        color = Color.Blue,
        textDecoration = TextDecoration.Underline
    ) // create a hyperlink text style

    builder.addStyle(hyperlinkStyle, start, end) // style "my website" to make it look like a link
    builder.addStringAnnotation(
        TAG,
        link,
        start,
        end
    ) // attach the link to the span. We can then access it via the TAG_URL

    return builder.toAnnotatedString()
}