package com.kamel.movieticket.navigate

sealed class Screen(val route: String) {
    object DetailsScreen : Screen("MovieDetailsScreen")
    object HomeScreen : Screen("HomeScreen")
}
