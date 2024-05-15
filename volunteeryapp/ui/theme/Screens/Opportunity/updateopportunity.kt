package com.example.volunteeryapp.ui.theme.Screens.Opportunity
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.volunteeryapp.Data.OpportunityViewModel
import com.example.volunteeryapp.Models.Opportunity
import com.example.volunteeryapp.Navigations.ROUTE_UPDATE_OPPORTUNITY
import com.example.volunteeryapp.Navigations.ROUTE_VIEW_OPPORTUNITY
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun updateOpportunity(navController: NavHostController) {
    var context= LocalContext.current
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var date by remember { mutableStateOf(TextFieldValue("")) }
    var location by remember { mutableStateOf(TextFieldValue("")) }
    var duration by remember { mutableStateOf(TextFieldValue("")) }
    fun saveOpportunity() {
        // Implement logic to save opportunity details here
        // For demonstration purposes, simply print the details to log
        println("Title: ${title.text}")
        println("Description: ${description.text}")
        println("Date: ${date.text}")
        println("Location: ${location.text}")
        println("Duration: ${duration.text}")

    }


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        var write by remember { mutableStateOf("") }

        var currentDataRef = FirebaseDatabase.getInstance().getReference()
//            .child("Opportunity/$id")
//        currentDataRef.addValueEventListener(object: ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                var create = snapshot.getValue(Opportunity::class.java)
//                title = create!!.title
//                description = create!!.description
//                location = create!!.location
//                date = create!!.date
//                duration = create!!.duration
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
//            }
//        })
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "Title*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(text = "Description *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = location,
            onValueChange = { location= it },
            label = { Text(text = "Location *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )


        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = date,
            onValueChange = { date= it },
            label = { Text(text = "Date*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )


        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = duration,
            onValueChange = { duration = it },
            label = { Text(text = "Duration *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            //-----------WRITE THE UPDATE LOGIC HERE---------------//
            var createRepository = OpportunityViewModel(navController, context)
            createRepository.updateOpportunity(title.text.trim(),description.text.trim(),
                date.text.trim(), location.text.trim(),duration.text.trim(),)
            navController.navigate(ROUTE_VIEW_OPPORTUNITY)
        }) {
            Text(text = "Update")
        }

    }
}

@Preview
@Composable
fun updateOpportunityPreview() {
    updateOpportunity(rememberNavController(), )
}