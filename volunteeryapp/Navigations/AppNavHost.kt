package com.example.volunteeryapp.Navigations
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Screens.Dashboard.DashboardScreen
import com.example.volunteeryapp.ui.theme.Screens.Calender.CalendarScreen
//import com.example.volunteeryapp.ui.theme.Screens.Calender.CalendarPlannerScreen
import com.example.volunteeryapp.ui.theme.Screens.Dashboard.DashboardScreenOrg
import com.example.volunteeryapp.ui.theme.Screens.Home.HomeScreen
import com.example.volunteeryapp.ui.theme.Screens.Join.JoinScreen
import com.example.volunteeryapp.ui.theme.Screens.Login.LoginScreen
import com.example.volunteeryapp.ui.theme.Screens.OpportunitiesAvailable.OpportunityAvailableScreen
import com.example.volunteeryapp.ui.theme.Screens.Opportunity.AddOpportunityScreen
import com.example.volunteeryapp.ui.theme.Screens.Opportunity.updateOpportunity
//import com.example.volunteeryapp.ui.theme.Screens.Opportunity.UpdateOpportunity
//import com.example.volunteeryapp.ui.theme.Screens.Opportunity.ViewOpportunity
import com.example.volunteeryapp.ui.theme.Screens.Opportunity.viewOpportunity
//import com.example.volunteeryapp.ui.theme.Screens.Opportunity.ViewOpportunityScreen
//import com.example.volunteeryapp.ui.theme.Screens.Register.RegisterOrgScreen
import com.example.volunteeryapp.ui.theme.Screens.Register.RegisterScreen
import com.example.volunteeryapp.ui.theme.Screens.Search.SearchScreen
import com.example.volunteeryapp.ui.theme.Screens.Settings.SettingsScreen
import com.example.volunteeryapp.ui.theme.Screens.Welcome.WelcomeScreen
import com.example.volunteeryapp.ui.theme.Screens.view.ViewScreen

@Composable
fun AppNavHost(modifier: Modifier=Modifier, navController: NavHostController= rememberNavController(),startDestination: String= ROUTE_HOME) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_WELCOME) {
            WelcomeScreen(navController)
        }
        composable(ROUTE_JOIN) {
            JoinScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }

        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUTE_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUTE_DASHBOARDORG) {
            DashboardScreenOrg(navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_VIEW) {
            ViewScreen(navController)
        }
//        composable(ROUTE_REGISTERORG) {
//            RegisterOrgScreen(navController)
//        }
        composable(ROUTE_SETTINGS) {
            SettingsScreen(navController)
        }
        composable(ROUTE_SEARCH) {
            SearchScreen(navController)
        }
        composable(ROUTE_CALENDER) {
            CalendarScreen(navController)
        }
        composable(ROUTE_ADD_OPPORTUNITY) {
            AddOpportunityScreen(navController)
        }
        composable(ROUTE_VIEW_OPPORTUNITY) {
            viewOpportunity(navController)
        }
        composable(ROUTE_UPDATE_OPPORTUNITY) {
            updateOpportunity(navController)
        }
        composable(ROUTE_OPPORTUNITIES) {
            OpportunityAvailableScreen(navController)
        }


    }}