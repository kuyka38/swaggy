package com.kunji.swaggy.ui.screens.auth

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kunji.swaggy.R
import com.kunji.swaggy.navigation.ROUT_DASHBOARD2
import com.kunji.swaggy.navigation.ROUT_HOME
import com.kunji.swaggy.navigation.ROUT_REGISTER
import com.kunji.swaggy.ui.theme.oldyellow
import com.kunji.swaggy.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    authViewModel: AuthViewModel,
    navController: NavController,
    onLoginSuccess: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    LaunchedEffect(authViewModel) {
        authViewModel.loggedInUser = { user ->
            if (user == null) {
                Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            } else {
                if (user.role == "Buyer") {
                    navController.navigate(ROUT_DASHBOARD2) {}
                } else {
                    navController.navigate(ROUT_HOME) {}
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F1ED)) // light cream background
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            // Curved Top Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFFFFC947), Color(0xFFF6A623))
                        ),
                        shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Welcome Back",
                        fontSize = 28.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Please login in to continue",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(100.dp))

            // Login Form Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(oldyellow)

                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(oldyellow)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Email or Mobile
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email or Mobile number") },
                        leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email Icon") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Password
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password Icon") },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            val image = if (passwordVisible) painterResource(R.drawable.passwordshow) else painterResource(R.drawable.passwordhide)
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(image, contentDescription = if (passwordVisible) "Hide Password" else "Show Password")
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Forgot password?",
                        modifier = Modifier.align(Alignment.End),
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Gradient Login Button
                    Button(
                        onClick = {
                            if (email.isBlank() || password.isBlank()) {
                                Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT).show()
                            } else {
                                authViewModel.loginUser(email, password)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        shape = RoundedCornerShape(30.dp),
                        contentPadding = PaddingValues()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(Color(0xFFFFC947), Color(0xFFF6A623))
                                    ),
                                    shape = RoundedCornerShape(30.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Login", color = Color.White, fontSize = 16.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Register Link
                    TextButton(onClick = { navController.navigate(ROUT_REGISTER) }) {
                        Text(
                            text = "Don't have an account? Sign up",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}
