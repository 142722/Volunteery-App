package com.example.volunteeryapp.ui.theme.Screens.Register

//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.example.volunteeryapp.Data.AuthViewModel
//import com.example.volunteeryapp.Navigations.ROUTE_DASHBOARD
//import com.example.volunteeryapp.Navigations.ROUTE_LOGIN
//import com.example.volunteeryapp.Navigations.ROUTE_REGISTER
//
////import kotlin.coroutines.jvm.internal.CompletedContinuation.context
//
//@Composable
//fun RegisterScreen(navController: NavController) {
//    var context= LocalContext.current
//    var fullName by remember { mutableStateOf(TextFieldValue("")) }
//    var email by remember { mutableStateOf(TextFieldValue("")) }
//    var password by remember { mutableStateOf(TextFieldValue("")) }
//    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }
//    var errorMessage by remember { mutableStateOf<String?>(null) }
//
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        Text(
//            text = "Register as Volunteer",
//            style = MaterialTheme.typography.h5,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        OutlinedTextField(
//            value = fullName,
//            onValueChange = { fullName = it },
//            label = { Text("Full Name") },
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Email") },
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            singleLine = true,
//            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
//            keyboardActions = KeyboardActions(onNext = { /* Handle action */ }),
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        OutlinedTextField(
//            value = confirmPassword,
//            onValueChange = { confirmPassword = it },
//            label = { Text("Confirm Password") },
//            singleLine = true,
//            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
//            keyboardActions = KeyboardActions(onDone = {
//                if (password == confirmPassword) {
//                    // Passwords match, navigate to the next screen
//                    navController.navigate(ROUTE_REGISTER)
//                } else {
//                    errorMessage = "Passwords don't match"
//
//                }
//            }),
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Button(onClick = {
//            val myregister= AuthViewModel(navController,context)
//            myregister.register(fullName.text.trim(),email.text.trim(),password.text.trim(),confirmPassword.text.trim())
//            navController.navigate(ROUTE_DASHBOARD)
//
//        }, modifier = Modifier.fillMaxWidth()) {
//            Text(text = "Register ")
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//
//        TextButton(
//            onClick = {
//                // Navigate to login screen when "Already have an account? Login" link is clicked
//                navController.navigate(ROUTE_LOGIN)
//            }
//        ) {
//            Text("Already have an account? Login")
//        }
//    }
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun RegisterScreenPreview() {
//    RegisterScreen(rememberNavController())
//
//}
//
//
//
