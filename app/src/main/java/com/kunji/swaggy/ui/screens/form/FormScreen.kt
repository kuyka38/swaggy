package com.kunji.swaggy.ui.screens.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.kunji.swaggy.R
import com.kunji.swaggy.navigation.ROUT_ITEM
import com.kunji.swaggy.ui.theme.newyellow

@Composable
fun FormScreen(navController: NavController) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .background(newyellow)
            .fillMaxSize(),


        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {

        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.cart))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(
            composition, progress,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        //card
        Card(
            modifier = Modifier.fillMaxWidth().height(800.dp),
            shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)

        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Swaggy",
                    fontSize = 40.sp,
                    color = newyellow,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Join Us and Start Your Journey Today",
                    fontSize = 15.sp,
                )

                Spacer(modifier = Modifier.height(8.dp))

                //USERNAME

                TextField(
                    value = username,
                    onValueChange = { username = it },
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = ""
                        )
                    },
                    label = { Text(text = "Username") },
                    colors = TextFieldDefaults.colors(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)


                )


                //END OF USERNAME

                Spacer(modifier = Modifier.height(8.dp))

                //EMAIL

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = ""
                        )
                    },
                    label = { Text(text = "Email Address") },
                    colors = TextFieldDefaults.colors(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)


                )

                Spacer(modifier = Modifier.height(8.dp))

                //PASSWORD

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = ""
                        )
                    },
                    label = { Text(text = "Enter Password") },
                    colors = TextFieldDefaults.colors(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()


                )

                Spacer(modifier = Modifier.height(8.dp))

                //USERNAME

                TextField(
                    value = confirmpassword,
                    onValueChange = { confirmpassword = it },
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = ""
                        )
                    },
                    label = { Text(text = "Confirm Password") },
                    colors = TextFieldDefaults.colors(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()


                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(newyellow),
                    shape = RectangleShape,
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
                ) {

                    Text(text = "Sign Up")
                }

                TextButton(onClick = {}) {

                    Text(text = "Already have an Account? Login")
                }


            }
            //END OF MAIN LAYOUT


        }
    }



    }






@Preview(showBackground = true)
@Composable
fun FormScreenPreview(){

    FormScreen(navController = rememberNavController())
}