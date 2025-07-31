package com.kunji.swaggy.ui.screens.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kunji.swaggy.R
import com.kunji.swaggy.navigation.ROUT_CATEGORY
import com.kunji.swaggy.ui.theme.newyellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemScreen(navController: NavController) {

    val mContext = LocalContext.current


    Column(
        modifier = Modifier.fillMaxSize()
    ) {


        //Top appbar
        TopAppBar(
            title = { Text(text = "Products") },
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
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "cart"
                    )


                }

                IconButton(onClick = {
                    navController.navigate(ROUT_CATEGORY)


                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "notifications"
                    )


                }


            }

        )
        //end of top appbar


        //adding an image

        Image(
            painter = painterResource(com.kunji.swaggy.R.drawable.coat),
            contentDescription = "coat",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,

            )

        Spacer(modifier = Modifier.height(20.dp))

        //search bar

        //create a variable to store what is to be searched
        var search by remember { mutableStateOf("") }
        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search"
                )
            },
            placeholder = { Text(text = "Search products") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = newyellow,
                focusedBorderColor = Color.Gray
            )


        )


        //end of searchbar


        Spacer(modifier = Modifier.height(10.dp) )

        Text (
            text = "Other Products",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp) )


        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {


            //Row- carry from here
            Row (
                modifier = Modifier.padding(start = 20.dp)

            ){
                Image(
                    painter = painterResource(com.kunji.swaggy.R.drawable.cloth1),
                    contentDescription = "cloth",
                    modifier = Modifier.size(width = 200.dp, height = 250.dp).clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(10.dp) )

                //column
                Column() {

                    Text(text = "Stylish Ostrich coat", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(5.dp) )
                    Text(text = "Brand: Alexander Fashion", fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(5.dp) )
                    Text(text = "Price: ksh 79000", fontSize = 15.sp, textDecoration = TextDecoration.LineThrough)
                    Spacer(modifier = Modifier.height(5.dp) )
                    Text(text = "Now: ksh 69000", fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(5.dp) )
                    Text(text = "Materal: Ostrich feather & Wool", fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(5.dp) )

                    //rating starts
                    Row {
                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newyellow)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newyellow)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newyellow)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newyellow)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Black)
                    }

                    Button(
                        onClick = {
                            val simToolKitLaunchIntent =
                                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                        },
                        colors = ButtonDefaults.buttonColors(newyellow),
                        shape = RectangleShape,
                        modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
                    ) {

                        Text(text = "Buy Now")
                    }


                }



            }

            //End of row

            Spacer(modifier = Modifier.height(10.dp) )

            //Row
            Row (
                modifier = Modifier.padding(start = 20.dp)

            ){
                Image(
                    painter = painterResource(R.drawable.coat2),
                    contentDescription = "cloth",
                    modifier = Modifier.size(width = 200.dp, height = 250.dp).clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(10.dp) )

                //column
                Column() {

                    Text(text = "Designer men coat", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(5.dp) )
                    Text(text = "Brand: Tien Fashion", fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(5.dp) )
                    Text(text = "Price: ksh 99000", fontSize = 15.sp, textDecoration = TextDecoration.LineThrough)
                    Spacer(modifier = Modifier.height(5.dp) )
                    Text(text = "Now: ksh 89000", fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(5.dp) )
                    Text(text = "Materal: Kiwi feather & Wool", fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(5.dp) )

                    //rating starts
                    Row {
                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newyellow)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newyellow)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newyellow)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newyellow)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Black)
                    }
                    //end of row



                    Button(
                        onClick = {

                            val simToolKitLaunchIntent =
                                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                        },
                        colors = ButtonDefaults.buttonColors(newyellow),
                        shape = RectangleShape,
                        modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
                    ) {

                        Text(text = "Buy Now")
                    }



                }



            }

            //End of row- to hear


        }





    }


}






@Preview(showBackground = true)
@Composable
fun ItemScreenPreview(){

    ItemScreen(navController = rememberNavController())
}