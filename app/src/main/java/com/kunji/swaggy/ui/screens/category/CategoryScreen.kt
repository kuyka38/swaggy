package com.kunji.swaggy.ui.screens.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kunji.swaggy.navigation.ROUT_DETAIL
import com.kunji.swaggy.navigation.ROUT_ITEM
import com.kunji.swaggy.ui.theme.newyellow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(navController: NavController){

Column(
    modifier = Modifier.fillMaxSize()


     ) {
    //Top appbar
    TopAppBar(
        title = { Text(text = "Other Categories") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = newyellow,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "menu"
                )
            }
        },

        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "share"
                )


            }

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Information"
                )


            }


        }

    )
    //end of top appbar


    Spacer(modifier = Modifier.height(10.dp))

    Text (
        text = "Welcome to Swaggy!!",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))

    Text (
        text = "Discover unique styles across categories. Find something for every vibe",
        fontSize = 15.sp,
        modifier = Modifier.padding(start = 20.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))


    Text (
        text = "Shop by Category",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))

    //Card
    Card(
        onClick = {},
        modifier = Modifier.fillMaxWidth().height(200.dp).padding(start = 20.dp, end = 20.dp)
    ) {
        //defining a layout
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(com.kunji.swaggy.R.drawable.coat),
                contentDescription = "coat",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds

                )
            Text (
                text = "Jewellery",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,


            )

            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "favorite",
                modifier = Modifier.align(alignment = Alignment.TopStart).padding(6.dp),
                tint = Color.Gray
            )

        }



    }
    //End of Card

    Spacer(modifier = Modifier.height(10.dp))

    //Card
    Card(
        onClick = {},
        modifier = Modifier.fillMaxWidth().height(200.dp).padding(start = 20.dp, end = 20.dp)
    ) {
        //defining a layout
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(com.kunji.swaggy.R.drawable.coat),
                contentDescription = "coat",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds

            )
            Text (
                text = "Jewellery",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,


                )

            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "favorite",
                modifier = Modifier.align(alignment = Alignment.TopStart).padding(6.dp),
                tint = Color.Gray
            )

        }



    }
    //End of Card



    Spacer(modifier = Modifier.height(20.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "More categories coming soon...",
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        androidx.compose.material3.Button(

            onClick = {navController.navigate(ROUT_DETAIL) },
            colors = ButtonDefaults.buttonColors(containerColor = newyellow)


        ) {
            Text(text = "Explore All Products")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Follow us on Instagram @swaggy_ke",
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Need help? Contact us at support@swaggy.co.ke",
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "\"Wear the vibe. Live the vibe.\"",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    }





}







}

@Preview
@Composable
fun CategoryScreenPreview(){

    CategoryScreen(navController = rememberNavController())
}