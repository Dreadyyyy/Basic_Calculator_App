package com.example.basiccalculatorapp.data

data class CalculatorUiState(
    val shownExpression: String = "",
    val result: String = "",
    val snackbarMessage: String = ""
)
