package com.example.volunteeryapp.ui.theme.Screens.Calender
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CalendarScreen(navController: NavController) {
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val years = (currentYear..2090).toList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Select Year:",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        DropdownMenu(
            expanded = false,
            onDismissRequest = { /* Dismiss the dropdown */ }
        ) {
            years.forEach { year ->
                DropdownMenuItem(
                    onClick = { /* Handle year selection */ }
                ) {
                    Text(text = year.toString())
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Displaying Calendar
        val selectedYear = 2024 // Default selected year
        val selectedMonth = Calendar.getInstance().get(Calendar.MONTH) // Default selected month
        val calendar = Calendar.getInstance()
        calendar.set(selectedYear, selectedMonth, 1)

        val monthFormat = SimpleDateFormat("MMMM", Locale.getDefault())
        val dateFormat = SimpleDateFormat("dd", Locale.getDefault())
        val dayFormat = SimpleDateFormat("EEE", Locale.getDefault())

        Text(
            text = "${monthFormat.format(calendar.time)}, $selectedYear",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Displaying days of the week
        Row(modifier = Modifier.fillMaxWidth()) {
            val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
            daysOfWeek.forEach { day ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .background(color = Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = day,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Displaying dates
        val startDate = calendar.time
        val endDate = calendar.apply { add(Calendar.MONTH, 1) }.time
        val dates = mutableListOf<Date>()
        while (startDate < endDate) {
            dates.add(startDate)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            startDate.time = calendar.timeInMillis
        }

        LazyColumn {
            itemsIndexed(dates) { index, date ->
                val dayOfWeek = dayFormat.format(date)
                val dayOfMonth = dateFormat.format(date)

                Row(modifier = Modifier.fillMaxWidth()) {
                    // Day of the week
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(color = if (dayOfWeek == "Sun" || dayOfWeek == "Sat") Color.LightGray else Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = dayOfWeek,
                            textAlign = TextAlign.Center,
                            color = if (dayOfWeek == "Sun" || dayOfWeek == "Sat") Color.White else Color.Black
                        )
                    }

                    // Day of the month
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(color = if (dayOfWeek == "Sun" || dayOfWeek == "Sat") Color.LightGray else Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = dayOfMonth,
                            textAlign = TextAlign.Center,
                            color = if (dayOfWeek == "Sun" || dayOfWeek == "Sat") Color.White else Color.Black
                        )
                    }

                    // Placeholder for planning
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(color = if (dayOfWeek == "Sun" || dayOfWeek == "Sat") Color.LightGray else Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "", // You can replace this with actual planning functionality
                            textAlign = TextAlign.Center,
                            color = if (dayOfWeek == "Sun" || dayOfWeek == "Sat") Color.White else Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Preview
@Composable
fun CalendarScreenPreview() {
    CalendarScreen(rememberNavController())
}
