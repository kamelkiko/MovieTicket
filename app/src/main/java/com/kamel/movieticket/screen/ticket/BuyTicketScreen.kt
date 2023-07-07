package com.kamel.movieticket.screen.ticket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kamel.movieticket.R
import com.kamel.movieticket.composable.BottomSheet
import com.kamel.movieticket.composable.DefaultButton
import com.kamel.movieticket.composable.ExitIcon
import com.kamel.movieticket.composable.cinemaStyle
import com.kamel.movieticket.screen.ticket.composable.ChairState
import com.kamel.movieticket.screen.ticket.composable.DateChip
import com.kamel.movieticket.screen.ticket.composable.HourChip
import com.kamel.movieticket.screen.ticket.composable.RowOfPairOfChairs
import com.kamel.movieticket.screen.ticket.composable.SelectedRadioItem
import com.kamel.movieticket.ui.theme.Black87

@Composable
fun BuyTicketsScreen(
    navController: NavController,
    viewModel: BuyTicketViewModel = hiltViewModel(),
) {
    val buyTicketsUiState by viewModel.ticketUiState.collectAsState()
    BuyTicketsContent(
        navController = navController,
//            override fun doWhenSelectDay(day: Day) {
//                buyTicketsUiState = buyTicketsUiState.copy(selectedDay = day)
//            }
//
//            override fun doWhenSelectHour(hour: String) {
//                buyTicketsUiState = buyTicketsUiState.copy(selectedTime = hour)
//            }
//
//        },
        state = buyTicketsUiState,
        onClickDay = viewModel::dayClicked,
        onClickHour = viewModel::hourSelected,
    )
}

@Composable
fun BuyTicketsContent(
    state: BuyTicketsUiState,
    navController: NavController,
    modifier: Modifier = Modifier,
    onClickDay: (Day) -> Unit,
    onClickHour: (String) -> Unit,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val (xIcon, image, rowChairs1,
            rowChairs2, rowChairs3, rowChairs4,
            rowChairs5, information, bottomSheet) = createRefs()

        Box(modifier = Modifier.constrainAs(xIcon) {
            start.linkTo(parent.start, 16.dp)
            top.linkTo(parent.top, 16.dp)
        }) {
            ExitIcon() {
                navController.popBackStack()
            }
        }

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .cinemaStyle(clipRatio = 0.36f, rotationX = -57f)
                .constrainAs(image) {
                    top.linkTo(xIcon.bottom, (-16).dp)
                },
        )

        val gap = 50
        /// region chairs
        RowOfPairOfChairs(
            pairList = listOf(
                Pair(ChairState.Available, ChairState.Available),
                Pair(ChairState.Available, ChairState.Available),
                Pair(ChairState.Taken, ChairState.Available),
            ),
            modifier = Modifier.constrainAs(rowChairs1) {
                top.linkTo(image.bottom, (-8).dp)
            }
        )
        RowOfPairOfChairs(
            pairList = listOf(
                Pair(ChairState.Available, ChairState.Available),
                Pair(ChairState.Available, ChairState.Available),
                Pair(ChairState.Available, ChairState.Available),
            ),
            modifier = Modifier.constrainAs(rowChairs2) {
                top.linkTo(rowChairs1.bottom, (-gap).dp)
            }
        )

        RowOfPairOfChairs(
            pairList = listOf(
                Pair(ChairState.Taken, ChairState.Available),
                Pair(ChairState.Available, ChairState.Available),
                Pair(ChairState.Taken, ChairState.Taken),
            ),
            modifier = Modifier.constrainAs(rowChairs3) {
                top.linkTo(rowChairs2.bottom, (-gap).dp)
            }
        )

        RowOfPairOfChairs(
            pairList = listOf(
                Pair(ChairState.Available, ChairState.Available),
                Pair(ChairState.Taken, ChairState.Taken),
                Pair(ChairState.Available, ChairState.Available),
            ),
            modifier = Modifier.constrainAs(rowChairs4) {
                top.linkTo(rowChairs3.bottom, (-gap).dp)
            }
        )
        RowOfPairOfChairs(
            pairList = listOf(
                Pair(ChairState.Taken, ChairState.Taken),
                Pair(ChairState.Taken, ChairState.Taken),
                Pair(ChairState.Available, ChairState.Available),
            ),
            modifier = Modifier.constrainAs(rowChairs5) {
                top.linkTo(rowChairs4.bottom, (-gap).dp)
            }
        )
        /// endregion
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(information) {
                    top.linkTo(rowChairs5.bottom, margin = (-8).dp)
                    bottom.linkTo(bottomSheet.top)
                },
            horizontalArrangement = Arrangement.SpaceAround,
        ) { Information() }

        BottomSheet(
            modifier = Modifier.constrainAs(bottomSheet) {
                bottom.linkTo(parent.bottom)
            }
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(state.days) {
                    DateChip(
                        it,
                        isSelected = it == state.selectedDay,
                        doWhenSelect = onClickDay
                    )
                }
            }
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(state.timeList) {
                    HourChip(
                        it,
                        isSelected = it == state.selectedTime,
                        doWhenSelectHour = onClickHour,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "$${state.price}",
                        fontSize = 24.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        color = Black87,
                    )
                    Text(
                        text = "${state.ticketsCount} tickets",
                        fontSize = 11.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        color = Black87
                    )

                }
                DefaultButton(
                    title = stringResource(id = R.string.booking),
                    icon = painterResource(id = R.drawable.ticket),
                    contentDescription = stringResource(id = R.string.booking),
                ) {

                }
            }
        }
    }
}

@Composable
private fun Information() {
    SelectedRadioItem(chairState = ChairState.Available)
    SelectedRadioItem(chairState = ChairState.Taken)
    SelectedRadioItem(chairState = ChairState.Selected)
}