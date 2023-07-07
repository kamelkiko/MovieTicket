package com.kamel.movieticket.screen.ticket

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BuyTicketViewModel @Inject constructor() : ViewModel() {
    private val _ticketUiState = MutableStateFlow(BuyTicketsUiState())
    val ticketUiState = _ticketUiState.asStateFlow()

    fun dayClicked(day: Day) {
        _ticketUiState.update {
            it.copy(
                selectedDay = day
            )
        }
    }

    fun hourSelected(hour: String) {
        _ticketUiState.update {
            it.copy(
                selectedTime = hour,
            )
        }
    }
}