package com.example.volunteeryapp.ui.theme.Screens.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.volunteeryapp.Navigations.ROUTE_DASHBOARD
import com.example.volunteeryapp.Navigations.ROUTE_DASHBOARDORG
import com.example.volunteeryapp.R


@Composable
fun ViewScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier)
{


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ){





            Button(onClick = {

                navController.navigate(ROUTE_DASHBOARD)


            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Volunteer")
            }
            Spacer(modifier = Modifier.height(100.dp))


            Button(onClick = {

                navController.navigate(ROUTE_DASHBOARDORG)


            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Organiser")
            }

        }

    }


@Preview(showBackground = true , showSystemUi = true)
@Composable
fun WelcomeScreenPreview(){
    ViewScreen(rememberNavController())
}