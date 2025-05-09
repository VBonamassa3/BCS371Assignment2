package com.example.assignment2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun BookListScreen(navController: NavHostController, modifier: Modifier) {
    Column(modifier){
        ButtonsFun(navController)
        BookListFun()
    }
}

@Composable
fun BookListFun(modifier: Modifier = Modifier) {
    val repository = MyApp.x
    val bookViewModel = viewModel { BookListViewModel(repository) }
    val bookList = bookViewModel.obtainBooks()
    Surface(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text("Book List", fontSize = 30.sp, color = (MaterialTheme.colorScheme.primary),
                fontWeight = (FontWeight.Bold), style = (MaterialTheme.typography.headlineMedium))
            LazyColumn (modifier){
                items(bookList) { currentItem ->
                    Text(text = currentItem.title, fontSize = 16.sp, color = (MaterialTheme.colorScheme.primary),
                        fontWeight = (FontWeight.Bold))
                    Text(text = currentItem.genre, color = (Color.Magenta), style = (MaterialTheme.typography.bodyLarge))
                    Text(text = "$"+String.format("%.2f", currentItem.price), color = (Color.Magenta),
                        style = (MaterialTheme.typography.bodyLarge))
                }
            }
        }
    }
}

@Composable
fun ButtonsFun(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate("StatsScreen")
                })
            {
                Text(text = "Statistics Screen")
            }
            Button(
                onClick = {
                    navController.navigate("AppInfoScreen")
                })
            {
                Text(text = "App Info Screen")
            }
        }
    }
}