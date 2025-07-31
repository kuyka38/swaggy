package com.kunji.swaggy.ui.screens.splash

import android.annotation.SuppressLint
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
import com.kunji.swaggy.navigation.ROUT_HOME
import com.kunji.swaggy.ui.theme.newyellow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){

    val coroutine = rememberCoroutineScope()
    coroutine.launch {
        delay(2000)
        navController.navigate(ROUT_HOME)
    }





    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        //Lottie Animation (funton to diplay an animation)
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.cart))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(composition, progress,
            modifier = Modifier.size(300.dp)
        )

        //End of the Function displaying an animation

        Spacer(modifier = Modifier.height(10.dp) )

        Text(
            text = "Shop Smart. Live Better",
            fontSize = 20.sp,
            color = newyellow,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp) )


        Text(
            text = "Thousands of products at your fingertips.Great deals. Fast delivery",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = newyellow,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp) )

        CircularProgressIndicator(

            color = newyellow


        )






    }



}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){

    SplashScreen(navController = rememberNavController())
}