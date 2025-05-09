package com.example.assignment2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun StatsFun(navController: NavHostController, modifier: Modifier) {
    val repository = MyApp.x
    val statsViewModel = viewModel { StatsViewModel(repository) }
    val averageOverall = statsViewModel.obtainAvgPrice()
    val averageBio = statsViewModel.obtainBioAvgPrice()
    val averageSciFi = statsViewModel.obtainSciFiAvgPrice()
    val averageHelp = statsViewModel.obtainHelpAvgPrice()
    Surface(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp,
    ) {
        Column (
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text("Book Statistics", fontSize = 30.sp, color = (MaterialTheme.colorScheme.primary),
                fontWeight = (FontWeight.Bold), style = (MaterialTheme.typography.headlineMedium))
            Text("Average Price: $"+String.format("%.2f", averageOverall), color = (Color.Magenta),
                style = (MaterialTheme.typography.bodyLarge))
            Text("Biography Average Price: $"+String.format("%.2f", averageBio), color = (Color.Magenta),
                style = (MaterialTheme.typography.bodyLarge))
            Text("Science Fiction Average Price: $"+String.format("%.2f", averageSciFi), color = (Color.Magenta),
                style = (MaterialTheme.typography.bodyLarge))
            Text("Self-Help Average Price: $"+String.format("%.2f", averageHelp), color = (Color.Magenta),
                style = (MaterialTheme.typography.bodyLarge))
            Button(
                onClick = {
                    navController.popBackStack()
                }
            )
            {
                Text(text="Go Back to Book List")
            }
        }
    }
}