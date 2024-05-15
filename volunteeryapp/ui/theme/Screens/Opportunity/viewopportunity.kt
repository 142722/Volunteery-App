package com.example.volunteeryapp.ui.theme.Screens.Opportunity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.volunteeryapp.Data.OpportunityViewModel
import com.example.volunteeryapp.Models.Opportunity
import com.example.volunteeryapp.Navigations.ROUTE_OPPORTUNITIES
import com.example.volunteeryapp.Navigations.ROUTE_UPDATE_OPPORTUNITY
import com.example.volunteeryapp.ui.theme.Screens.OpportunitiesAvailable.OpportunityItem

@Composable
fun viewOpportunity(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current
        val OpportunityRepository = OpportunityViewModel(navController, context)
        val emptyOpportunityState = remember { mutableStateOf(Opportunity("","","","","","")) }
        val emptyOpportunityListState = remember { mutableStateListOf<Opportunity>() }
        val Opportunity = OpportunityRepository.viewOpportunity(emptyOpportunityState, emptyOpportunityListState)

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All Opportunities",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(){
                items(Opportunity){
                    OpportunityItem(
                        id = it.id,
                        title = it.title,
                        description = it.description,
                        location = it.location,
                        date = it.date,
                        duration = it.duration,
                        navController = navController,
                        OpportunityRepository = OpportunityRepository
                    )
                }
            }
        }
    }
}

@Composable
fun OpportunityItem(id:String,title:String,description:String,location:String,date:String,duration:String,
                navController:NavController, OpportunityRepository:OpportunityViewModel) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Card (modifier = Modifier.size(150.dp)) {
            Text(text = id )
            Text(text = title)
            Text(text = description)
            Text(text = location)
            Text(text = date)
            Text(text = duration)
            Button(onClick = {
                OpportunityRepository.deleteOpportunity(id)
            }) {
                Text(text = "Delete")
            }
            Button(onClick = {
                navController.navigate(ROUTE_UPDATE_OPPORTUNITY)
            }) {
                Text(text = "Update")
            }
            Button(onClick = {
                navController.navigate(ROUTE_OPPORTUNITIES)
            }) {
                Text(text = "Save")
            }
        }
    }
}


@Preview
@Composable
fun viewOpportunity() {
    viewOpportunity(rememberNavController())
}