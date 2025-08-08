package com.kunji.swaggy.ui.screens.auth

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kunji.swaggy.R
import com.kunji.swaggy.model.User
import com.kunji.swaggy.navigation.ROUT_LOGIN
import com.kunji.swaggy.ui.theme.newyellow
import com.kunji.swaggy.ui.theme.oldyellow
import com.kunji.swaggy.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    authViewModel: AuthViewModel,
    navController: NavController,
    onRegisterSuccess: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var role by remember { mutableStateOf("student") }
    val roleOptions = listOf("Buyer", "Seller")
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(oldyellow)
    ) {
        Column(
            modifier = Modifier
                .background(oldyellow)
                .fillMaxSize()

        ) {
            // Top Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFFFC947),
                                Color(0xFFF6A623)
                            )
                        ),
                        shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Create Account",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontFamily = FontFamily.SansSerif
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Form Card
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
                        .padding(16.dp)
                        .background(oldyellow)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Username
                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username") },
                        leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Username Icon") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Email
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email Icon") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Role Dropdown
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded }
                    ) {
                        OutlinedTextField(
                            value = role,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Select Role") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            modifier = Modifier.menuAnchor().fillMaxWidth()
                        )
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            roleOptions.forEach { selectionOption ->
                                DropdownMenuItem(
                                    text = { Text(selectionOption) },
                                    onClick = {
                                        role = selectionOption
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Password
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password Icon") },
                        trailingIcon = {
                            val image = if (passwordVisible) painterResource(R.drawable.passwordshow) else painterResource(R.drawable.passwordhide)
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(image, contentDescription = if (passwordVisible) "Hide Password" else "Show Password")
                            }
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Confirm Password
                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text("Confirm Password") },
                        visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Confirm Password Icon") },
                        trailingIcon = {
                            val image = if (confirmPasswordVisible) painterResource(R.drawable.passwordshow) else painterResource(R.drawable.passwordhide)
                            IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                                Icon(image, contentDescription = if (confirmPasswordVisible) "Hide Password" else "Show Password")
                            }
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Sign Up Button
                    Button(
                        onClick = {
                            if (username.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                                Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT).show()
                            } else if (password != confirmPassword) {
                                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                            } else {
                                authViewModel.registerUser(User(username = username, email = email, role = role, password = password))
                                onRegisterSuccess()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
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
                            Text("Sign up", color = Color.White, fontSize = 16.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    TextButton(onClick = { navController.navigate(ROUT_LOGIN) }) {
                        Text("Already have an account? Login")
                    }
                }
            }
        }
    }
}
