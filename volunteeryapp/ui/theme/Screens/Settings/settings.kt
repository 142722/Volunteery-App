package com.example.volunteeryapp.ui.theme.Screens.Settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.volunteeryapp.R





@Composable
fun SettingsScreen(navController: NavController) {
    // Remember the state of the switch button
    val isDarkModeEnabled = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Pass the state of the switch button to SettingsOption
        SettingsOption(
            title = "Dark Mode",
            isChecked = isDarkModeEnabled.value,
            // Update the state of the switch button when it's toggled
            onCheckedChange = { isChecked -> isDarkModeEnabled.value = isChecked }
        )
        Divider(modifier = Modifier.padding(vertical = 8.dp))
    }
}

@Composable
fun SettingsOption(title: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.weight(1f)
        )
        if (title == "Dark Mode") {
            Switch(
                checked = isChecked,
                onCheckedChange = onCheckedChange,
                // Provide custom colors for Dark Mode
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Black,
                    checkedTrackColor = Color.Black.copy(alpha = 0.5f)
                )
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.app_settings),
                contentDescription = "Settings",
                modifier = Modifier.size(120.dp),
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(rememberNavController())
}
