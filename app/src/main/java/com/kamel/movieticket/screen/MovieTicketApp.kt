package com.kamel.movieticket.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MovieTicketApp(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("MovieDetailsScreen") { MovieDetailsScreen(navHostController = navController) }
        composable("HomeScreen") { HomeScreen(navHostController = navController) }
    }

}