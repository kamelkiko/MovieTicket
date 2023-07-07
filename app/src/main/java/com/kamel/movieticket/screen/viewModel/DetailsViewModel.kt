package com.kamel.movieticket.screen.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kamel.movieticket.data.getMovieById
import com.kamel.movieticket.screen.state.DetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(DetailsUiState())
    val state = _state.asStateFlow()

    private val args: String = checkNotNull(savedStateHandle["id"])

    init {
        getMovie()
    }

    private fun getMovie() {
        _state.update {
            it.copy(
                movie = getMovieById(args.toInt())
            )
        }
    }
}