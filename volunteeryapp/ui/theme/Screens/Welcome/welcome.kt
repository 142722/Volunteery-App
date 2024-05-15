package com.example.volunteeryapp.ui.theme.Screens.Welcome


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.Button
//import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.volunteeryapp.Navigations.ROUTE_DASHBOARD
import com.example.volunteeryapp.Navigations.ROUTE_JOIN
import com.example.volunteeryapp.R
//import com.example.myapplication.Navigations.ROUTE_HOME
import com.example.volunteeryapp.Navigations.ROUTE_REGISTER
//import com.example.volunteeryapp.Screens.Login.LoginScreen


@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {Image(
        painter = painterResource(id = R.drawable.applogo),
        contentDescription = "App Logo",
        modifier = Modifier.size(120.dp),
    )
        // Welcome text
        Text(
            text = "Welcome to our Volunteering App!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Explanation text
        Text(
            text = "Join us in making a difference in the community!",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 32.dp)
        )


        // Button to navigate to the next screen (e.g., login or sign up)
        Button(
            onClick = {navController.navigate(ROUTE_JOIN)},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            Text(text = "Get Started")
        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController())
}

