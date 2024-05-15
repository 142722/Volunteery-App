package com.example.volunteeryapp.ui.theme.Screens.Opportunity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
//import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.volunteeryapp.Data.OpportunityViewModel
import com.example.volunteeryapp.Models.Opportunity
import com.example.volunteeryapp.Navigations.ROUTE_OPPORTUNITIES
import com.example.volunteeryapp.Navigations.ROUTE_UPDATE_OPPORTUNITY
import com.example.volunteeryapp.Navigations.ROUTE_VIEW_OPPORTUNITY
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@Composable
fun AddOpportunityScreen(navController: NavController) {
    var context= LocalContext.current
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var date by remember { mutableStateOf(TextFieldValue("")) }
    var location by remember { mutableStateOf(TextFieldValue("")) }
    var duration by remember { mutableStateOf(TextFieldValue("")) }


    // Function to save opportunity details
    fun saveOpportunity() {
        // Implement logic to save opportunity details here
        // For demonstration purposes, simply print the details to log
        println("Title: ${title.text}")
        println("Description: ${description.text}")
        println("Date: ${date.text}")
        println("Location: ${location.text}")
        println("Duration: ${duration.text}")

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Create New Opportunity..",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        TextField(
            value = date,
            onValueChange = { date= it },
            label = { Text("Date") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        TextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        TextField(
            value =duration,
            onValueChange = { duration = it },
            label = { Text("Duration") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Button(onClick = {
            val opportunityRepository = OpportunityViewModel(navController,context)
            opportunityRepository.saveOpportunity(title.text.trim(),description.text.trim(), date.text.trim(), location.text.trim(),duration.text.trim(),
                )
            navController.navigate(ROUTE_VIEW_OPPORTUNITY)
        }) {
            Text(text = "View")
        }
        }}

@Preview(showBackground = true)
@Composable
fun AppOpportunityScreenPreview() {
    AddOpportunityScreen(rememberNavController())
}


