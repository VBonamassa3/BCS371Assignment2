package com.example.assignment2

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = "BookListScreen", modifier) {
        composable(route="BookListScreen") {
            BookListScreen(navController, modifier)
        }
        composable(route="StatsScreen") {
            StatsFun(navController, modifier)
        }
        composable(route="AppInfoScreen") {
            AppInfoFun(navController, modifier)
        }
    }
}