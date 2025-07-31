package com.kunji.swaggy.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kunji.swaggy.navigation.ROUT_ITEM
import com.kunji.swaggy.ui.theme.newyellow
import com.kunji.swaggy.ui.theme.oldyellow

@Composable
fun HomeScreen(navcontroller: NavController){

    Column(
       modifier = Modifier.fillMaxSize().background(oldyellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Image(
            painter = painterResource(com.kunji.swaggy.R.drawable.cloth1),
            contentDescription = "cloth",
            modifier = Modifier.size(300.dp) )

        Spacer(modifier = Modifier.height(10.dp) )




        Text(
            text = "Swaggy",
            fontSize = 40.sp,
            color = newyellow,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp) )

        Text(
            text = "Find More Products",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold )


        Spacer(modifier = Modifier.height(10.dp) )

        Text(
            text = "Shop for Winter Clothes from a Huge Collection - Get Best Winter Clothes Online from Jumia Kenya | Fast Delivery - Free Returns.",
            fontSize = 15.sp,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(10.dp) )


        Button(
            onClick = {
                navcontroller.navigate(ROUT_ITEM)
            },
            colors = ButtonDefaults.buttonColors(newyellow),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        ) {

            Text(text = "Get Started")
        }


    }



}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){

    HomeScreen(navcontroller = rememberNavController())
}