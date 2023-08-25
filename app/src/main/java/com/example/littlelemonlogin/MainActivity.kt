package com.example.littlelemonlogin

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LittleLemonLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

//@Preview
@Composable
fun LoginScreen(){
    val inputvalueUserName = remember {
        mutableStateOf(TextFieldValue())
    }
    val inputvaluePassword = remember {
        mutableStateOf(TextFieldValue())
    }

    Column(Modifier.fillMaxSize()
        , verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(id= R.drawable.littlelemonlogo), contentDescription = "Logo Image")
        TextField(value = inputvalueUserName.value, onValueChange = {inputvalueUserName.value = it}
        , placeholder = {Text(text = stringResource(id = R.string.user_name))})
        TextField(value = inputvaluePassword.value, onValueChange = {inputvaluePassword.value = it}
            , placeholder = {Text(text = stringResource(id = R.string.password))})
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(
            id = R.color.button_color)) )
        {
            Text(text = stringResource(id= R.string.Login),
            color = colorResource(id = R.color.text_button))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}