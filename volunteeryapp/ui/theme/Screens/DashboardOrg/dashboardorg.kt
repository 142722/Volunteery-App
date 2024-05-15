package com.example.volunteeryapp.ui.theme.Screens.Dashboard
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.volunteeryapp.R
import androidx.navigation.compose.rememberNavController
import com.example.volunteeryapp.Navigations.ROUTE_ADD_OPPORTUNITY
import com.example.volunteeryapp.Navigations.ROUTE_CALENDER
import com.example.volunteeryapp.Navigations.ROUTE_SETTINGS

@Composable
fun DashboardScreenOrg(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar()
        Spacer(modifier = Modifier.height(16.dp))
        NavigationItem(text = "My Calendar", icon = R.drawable._calendar_month) {
            navController.navigate(ROUTE_CALENDER)
        }
        Spacer(modifier = Modifier.height(16.dp))
        NavigationItem(text = "Opportunities", icon = R.drawable.opportunity) {
            navController.navigate(ROUTE_ADD_OPPORTUNITY)
        }
        Spacer(modifier = Modifier.height(16.dp))
        NavigationItem(text = "Settings", icon = R.drawable.app_settings) {
            navController.navigate(ROUTE_SETTINGS)
        }
    }
}
@Composable
fun AppBar() {
    TopAppBar(
        title = { Text(text = "Dashboard") },
//        backgroundColor = Color.SkyBlue,
        contentColor = Color.White,
        elevation = 4.dp
    )
}

@Composable
fun NavigationItem(text: String, icon: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable(onClick = onClick),
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier.size(48.dp),
//                tint = Color.Blue
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = text, style = MaterialTheme.typography.body1)
        }
    }
}

@Preview
@Composable
fun PreviewDashboardScreenOrg() {
    DashboardScreenOrg(rememberNavController())
}
