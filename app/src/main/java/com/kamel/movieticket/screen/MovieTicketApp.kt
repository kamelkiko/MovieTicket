package com.kamel.movieticket.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun MovieTicketApp(
    navController: NavHostController? = null
) {
    MovieDetailsScreen()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewMovieTicketApp() {
    MovieTicketApp()
}