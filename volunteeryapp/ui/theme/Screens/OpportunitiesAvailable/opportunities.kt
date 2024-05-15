package com.example.volunteeryapp.ui.theme.Screens.OpportunitiesAvailable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// Sample data class representing an opportunity
data class Opportunity(val id: Int, val title: String, val description: String)

@Composable
fun OpportunityAvailableScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Available Opportunities", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun OpportunityList(
    opportunities: List<Opportunity>,
    navigateToOpportunityDetail: (Int) -> Unit
) {
    LazyColumn {
        items(opportunities) { opportunity ->
            OpportunityItem(opportunity = opportunity, navigateToOpportunityDetail)
            Divider()
        }
    }
}

@Composable
fun OpportunityItem(
    opportunity: Opportunity,
    navigateToOpportunityDetail: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = opportunity.title, style = MaterialTheme.typography.subtitle1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = opportunity.description, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navigateToOpportunityDetail(opportunity.id) }) {
                Text(text = "View Details")
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewOpportunityAvailableScreen() {
    val opportunities = listOf(
        Opportunity(1, "Volunteer at Local Shelter", "Helping with feeding and taking care of animals."),
        Opportunity(2, "Community Clean-up Event", "Join us in keeping our community clean and green.")
    )
    // Assuming you have a function to navigate to opportunity details
    fun navigateToOpportunityDetail(id: Int) {
        // Navigation logic
    }
    OpportunityAvailableScreen(rememberNavController())
}

