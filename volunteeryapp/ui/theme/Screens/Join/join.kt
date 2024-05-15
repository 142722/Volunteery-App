package com.example.volunteeryapp.ui.theme.Screens.Join



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
//import com.example.myapplication.Screens.Login.LoginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.volunteeryapp.Navigations.ROUTE_JOIN
import com.example.volunteeryapp.Navigations.ROUTE_LOGIN
import com.example.volunteeryapp.Navigations.ROUTE_REGISTER
import com.example.volunteeryapp.Navigations.ROUTE_REGISTERORG
import com.example.volunteeryapp.R

//import androidx.navigation.NavController

@Composable
fun JoinScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),


            )
        // Content
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Join Our Volunteering Community",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                onClick = { navController.navigate(ROUTE_LOGIN) },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Login")
            }
            Button(
                onClick = {navController.navigate(ROUTE_REGISTER)},
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Register")
            }
//            Button(
//                onClick = {navController.navigate(ROUTE_REGISTERORG) },
//                modifier = Modifier
//                    .fillMaxWidth()
//            ) {
//                Text(text = "Register as Organizer")
//            }
        }
    }
    }

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun JoinScreenPreview() {
    JoinScreen(rememberNavController())
}