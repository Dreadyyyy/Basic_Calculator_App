package com.example.basiccalculatorapp.ui.screens.content

import androidx.lifecycle.ViewModel
import com.example.basiccalculatorapp.data.HistoryUiState
import kotlinx.coroutines.flow.MutableStateFlow

class HistoryViewModel: ViewModel() {
    val historyUiState: MutableStateFlow<HistoryUiState> = MutableStateFlow(
        HistoryUiState()
    )
}