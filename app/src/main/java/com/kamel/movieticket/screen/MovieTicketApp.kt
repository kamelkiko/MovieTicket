package com.kamel.movieticket.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kamel.movieticket.navigate.Screen

@Composable
fun MovieTicketApp(
    navController: NavHostController,
    toYoutube: (String) -> Unit
) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(
            Screen.DetailsScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") { NavType.StringType },
            ),
        ) {
            MovieDetailsScreen(
                navHostController = navController,
                toYoutube = toYoutube
            )
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navHostController = navController)
        }
    }

}