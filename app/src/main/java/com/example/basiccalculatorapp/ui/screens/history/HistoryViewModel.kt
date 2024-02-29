package com.example.basiccalculatorapp.ui.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basiccalculatorapp.data.ExpressionsRepository
import com.example.basiccalculatorapp.ui.screens.history.HistoryUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HistoryViewModel(private val expressionsRepository: ExpressionsRepository): ViewModel() {
    val historyUiState: StateFlow<HistoryUiState> =
        expressionsRepository.getAllItemStream().map { HistoryUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HistoryUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}