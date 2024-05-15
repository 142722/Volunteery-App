package com.example.volunteeryapp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
//import com.google.firebase.ktx.Firebase
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Screens.Dashboard.DashboardScreen
import com.example.volunteeryapp.Navigations.AppNavHost
import com.example.volunteeryapp.Navigations.ROUTE_WELCOME
//import com.example.volunteeryapp.ui.theme.Screens.Calender.CalendarPlannerScreen
import com.example.volunteeryapp.ui.theme.Screens.Calender.CalendarScreen
import com.example.volunteeryapp.ui.theme.Screens.Dashboard.DashboardScreenOrg
//import com.example.volunteeryapp.ui.theme.Screens.Dashboard.DashboardScreen
//import com.example.volunteeryapp.ui.theme.Screens.DashboardOrg.DashboardOrgScreen
import com.example.volunteeryapp.ui.theme.Screens.Join.JoinScreen
import com.example.volunteeryapp.ui.theme.Screens.Login.LoginScreen
import com.example.volunteeryapp.ui.theme.Screens.OpportunitiesAvailable.OpportunityAvailableScreen
import com.example.volunteeryapp.ui.theme.Screens.Opportunity.AddOpportunityScreen
import com.example.volunteeryapp.ui.theme.Screens.Opportunity.updateOpportunity
import com.example.volunteeryapp.ui.theme.Screens.Opportunity.viewOpportunity
//import com.example.volunteeryapp.ui.theme.Screens.Opportunity.UpdateOpportunityScreen
//import com.example.volunteeryapp.ui.theme.Screens.Opportunity.ViewOpportunityScreen
//import com.example.volunteeryapp.ui.theme.Screens.Notifications.NotificationScreen
//import com.example.volunteeryapp.ui.theme.Screens.Register.RegisterOrgScreen
import com.example.volunteeryapp.ui.theme.Screens.Register.RegisterScreen
import com.example.volunteeryapp.ui.theme.Screens.Settings.SettingsScreen
import com.example.volunteeryapp.ui.theme.Screens.Welcome.WelcomeScreen
import com.example.volunteeryapp.ui.theme.Screens.view.ViewScreen
import com.example.volunteeryapp.ui.theme.VolunteeryAppTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class MainActivity : ComponentActivity() {
    private lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
        setContent {
            VolunteeryAppTheme {
                Surface (
                    modifier =Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface
                )
                {
                    val firebaseUser = FirebaseAuth.getInstance().currentUser
                val navController = rememberNavController()
                AppNavHost()

                // Set the start destination
//                navController.graph.startDestination = "dashboard"

                // Set content view to NavHost
                VolunteeryApp(navController)
            }
        }
    }
}

@Composable
fun VolunteeryApp(navController: NavHostController) {
    NavHost(navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("join") {
            JoinScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("register") {
            RegisterScreen(navController)
        }
        composable("view") {
            ViewScreen(navController)
        }
        composable("dashboard") {
            DashboardScreen(navController)
        }
        composable("dashboardOrg") {
            DashboardScreenOrg(navController)
        }
        composable("calender") {
            CalendarScreen(navController)
        }
        composable("dashboard") {
            DashboardScreen(navController)
        }
        composable("settings") {
            SettingsScreen(navController)
        }
        composable("opportunity") {
            OpportunityAvailableScreen(navController)
        }
        composable("addOpportunity") {
            AddOpportunityScreen(navController)
        }
        composable("viewOpportunity") {
            viewOpportunity(navController)
        }
        composable("updateOpportunity") {
            updateOpportunity(navController)
        }
        composable("opportunity") {
            OpportunityAvailableScreen(navController)
        }
        // Define more screens as needed

}}}



