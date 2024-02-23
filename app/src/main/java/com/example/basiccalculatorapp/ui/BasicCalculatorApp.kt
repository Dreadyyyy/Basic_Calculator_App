package com.example.basiccalculatorapp.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basiccalculatorapp.data.CalculatorButton
import com.example.basiccalculatorapp.ui.utils.ButtonsPaneType
import com.example.basiccalculatorapp.model.CalculatorUiState
import com.example.basiccalculatorapp.ui.screens.CalculatorScreen
import com.example.basiccalculatorapp.ui.screens.CalculatorViewModel

@Composable
fun BasicCalculatorApp(
    calculatorViewModel: CalculatorViewModel = viewModel(),
    windowWidthSizeClass: WindowWidthSizeClass
) {
    val calculatorUiState: State<CalculatorUiState> = calculatorViewModel.calculatorUiState.collectAsState()
    val buttonsPaneType: ButtonsPaneType =
        if (windowWidthSizeClass == WindowWidthSizeClass.Compact) ButtonsPaneType.Basic
        else ButtonsPaneType.Expanded
    CalculatorScreen(
        expression = calculatorUiState.value.shownExpression,
        result = calculatorUiState.value.result,
        buttonsPaneType = buttonsPaneType,
        onClickAction = { button: CalculatorButton -> calculatorViewModel.onButtonPressed(button) }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BasicCalculatorAppPreview() {
    BasicCalculatorApp(windowWidthSizeClass = WindowWidthSizeClass.Compact)
}