package com.kamel.movieticket.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kamel.movieticket.R
import com.kamel.movieticket.composable.BlurImage
import com.kamel.movieticket.composable.CardTime
import com.kamel.movieticket.composable.ChipChoose
import com.kamel.movieticket.composable.GenericChips
import com.kamel.movieticket.composable.MovieCard
import com.kamel.movieticket.composable.MovieName
import com.kamel.movieticket.composable.SpacerHorizontal
import com.kamel.movieticket.composable.SpacerVertical
import com.kamel.movieticket.domain.model.Movie
import com.kamel.movieticket.navigate.Screen
import com.kamel.movieticket.ui.theme.Black87
import com.kamel.movieticket.ui.theme.Orange

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(
        navHostController = navHostController,
        state,
        viewModel::onSwipeMovie,
        onClickChip = viewModel::onClickChip,
        isSelectedChip = state.isSelectedChip,
    )
}

@Composable
private fun HomeContent(
    navHostController: NavHostController,
    state: HomeUiState,
    onSwipe: (Movie) -> Unit,
    isSelectedChip: Boolean,
    onClickChip: () -> Unit,
) {
    var selectedItem by remember { mutableStateOf(0) }
    val items =
        listOf(R.drawable.video_player, R.drawable.search, R.drawable.ticket, R.drawable.profile)
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        BlurImage(state.blurImage)
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                ChipChoose(
                    tag = "Now Streaming",
                    isSelectedChip = isSelectedChip,
                    onClickChip = onClickChip,
                )
                SpacerHorizontal(space = 8)
                ChipChoose(
                    tag = "Coming Soon",
                    isSelectedChip = !isSelectedChip,
                    onClickChip = onClickChip,
                )
            }
            SpacerVertical(space = 16)
            MovieCard(state, onSwipe) { id ->
                navHostController.navigate(Screen.DetailsScreen.route + "/$id")
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.38f)
                .align(alignment = Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CardTime(
                painter = painterResource(id = R.drawable.clock),
                contentDescription = stringResource(
                    id = R.string.time
                ),
                time = state.currentMovie.time!!,
                backgroundColor = Color.Transparent,
                color = Black87,
            )
            SpacerVertical(space = 8)
            MovieName(state.currentMovie.name!!)
            SpacerVertical(space = 32)
            GenericChips()
            Spacer(modifier = Modifier.weight(1f))
            NavigationBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = Color.Transparent,
                tonalElevation = 0.dp,
            ) {
                items.forEachIndexed { index, _ ->
                    NavigationBarItem(
                        icon = { Icon(painter = painterResource(id = items[index]), null) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            unselectedIconColor = Color.Black,
                            indicatorColor = Orange,
                        ),
                    )
                }
            }
//            BottomAppBar(
//                modifier = Modifier.fillMaxWidth(),
//                containerColor = Color.Transparent,
//                contentColor = Color.Black
//            ) {
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceAround
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.video_player),
//                        contentDescription = "movie video playing",
//                        tint = Color.White,
//                        modifier = Modifier
//                            .clip(CircleShape)
//                            .background(Orange)
//                            .padding(8.dp)
//                    )
//                    Icon(
//                        painter = painterResource(id = R.drawable.search),
//                        contentDescription = "movie search",
//                        tint = Color.Black
//                    )
//                    Icon(
//                        painter = painterResource(id = R.drawable.ticket),
//                        contentDescription = "movie ticket",
//                        tint = Color.Black
//                    )
//                    Icon(
//                        painter = painterResource(id = R.drawable.profile),
//                        contentDescription = "profile logo",
//                        tint = Color.Black
//                    )
//                }
        }
    }
}