package com.example.volunteeryapp.ui.theme.Screens.Search
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SearchScreen(navController: NavController) {
    var searchText by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        TopAppBar(title = { Text(text = "Search") })
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(searchText = searchText, onSearchTextChange = { searchText = it })
        Spacer(modifier = Modifier.height(16.dp))
        // Add your search results composable here
        Text(text = "Search Results")
    }
}

@Composable
fun SearchBar(searchText: TextFieldValue, onSearchTextChange: (TextFieldValue) -> Unit) {
    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.LightGray,
        shape = RectangleShape
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            BasicTextField(
                value = searchText,
                onValueChange = { onSearchTextChange(it) },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp),
                textStyle = MaterialTheme.typography.body1.copy(color = Color.Black),
                cursorBrush = SolidColor(Color.Black),
                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.fillMaxSize()) {
                        innerTextField()
                    }
                }
            )
            IconButton(
                onClick = { /* Perform search action */ },
                modifier = Modifier.size(48.dp)
            ) {
                // Add search icon
                // Icon(Icons.Default.Search, contentDescription = "Search Icon")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(rememberNavController())
}


