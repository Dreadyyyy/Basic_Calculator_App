package com.example.basiccalculatorapp.ui.screens.history

import com.example.basiccalculatorapp.data.ExpressionEntity

data class HistoryUiState(
    val expressions: List<ExpressionEntity> = listOf()
)
