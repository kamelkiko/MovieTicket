package com.kamel.movieticket.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kamel.movieticket.R
import com.kamel.movieticket.composable.CardTime
import com.kamel.movieticket.composable.ExitIcon
import com.kamel.movieticket.composable.PosterImage

@Composable
fun MovieTicketApp(
    navController: NavHostController? = null
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.51f),
        ) {
            PosterImage(
                painter = painterResource(id = R.drawable.poster_movie),
                contentDescription = stringResource(id = R.string.poster_movie)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                ExitIcon()
                CardTime(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = stringResource(id = R.string.time),
                    time = "2h 23m",
                )
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewMovieTicketApp() {
    MovieTicketApp()
}