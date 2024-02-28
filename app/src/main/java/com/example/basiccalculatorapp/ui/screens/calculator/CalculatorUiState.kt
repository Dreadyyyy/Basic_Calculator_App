package com.example.basiccalculatorapp.ui.screens.calculator

data class CalculatorUiState(
    val shownExpression: String = "",
    val result: String = "",
    val snackbarMessage: String = ""
)
