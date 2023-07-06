package com.kamel.movieticket.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamel.movieticket.R
import com.kamel.movieticket.composable.ActorItem
import com.kamel.movieticket.composable.CardTag
import com.kamel.movieticket.composable.CardTime
import com.kamel.movieticket.composable.ExitIcon
import com.kamel.movieticket.composable.MovieName
import com.kamel.movieticket.composable.PosterImage
import com.kamel.movieticket.composable.SpacerHorizontal
import com.kamel.movieticket.composable.SpacerVertical
import com.kamel.movieticket.composable.TextPercentage
import com.kamel.movieticket.composable.TextRate
import com.kamel.movieticket.screen.viewModel.actors
import com.kamel.movieticket.ui.theme.Orange

@Composable
fun MovieDetailsScreen() {
    MovieDetailsContent()
}

@Composable
private fun MovieDetailsContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
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
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(56.dp)
                    .background(Orange, shape = CircleShape),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.play),
                    contentDescription = null,
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .size(24.dp)
                        .background(Orange, shape = CircleShape),
                    tint = Color.White,
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.58f)
                .align(alignment = Alignment.BottomCenter),
            elevation = CardDefaults.cardElevation(0.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                Rates()
            }
            MovieName("Fantastic Beats: The Secrets of Dumbledore")
            SpacerVertical(space = 16)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                CardTag(tag = "Fantasy")
                SpacerHorizontal(space = 8)
                CardTag(tag = "Adventure")
            }
            SpacerVertical(space = 8)
            Actors()
            SpacerVertical(space = 8)
            Text(
                text = "Professor Allbus Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him..",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.Black,
                    fontSize = 14.sp
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun Rates() {
    TextRate(rate = "6.8", "IMDB")
    TextPercentage(rate = "63%", "Rotten Tomatoes")
    TextRate(rate = "4", "IGN")
}

@Composable
private fun Actors() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(actors) {
            ActorItem(image = it)
        }
    }
}