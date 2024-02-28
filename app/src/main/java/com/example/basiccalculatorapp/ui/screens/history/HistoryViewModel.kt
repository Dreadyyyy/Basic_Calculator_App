package com.example.basiccalculatorapp.ui.screens.history

import androidx.lifecycle.ViewModel
import com.example.basiccalculatorapp.data.ExpressionsRepository
import com.example.basiccalculatorapp.ui.screens.history.HistoryUiState
import kotlinx.coroutines.flow.MutableStateFlow

class HistoryViewModel(private val expressionsRepository: ExpressionsRepository): ViewModel() {
    val historyUiState: MutableStateFlow<HistoryUiState> = MutableStateFlow(
        HistoryUiState()
    )
}