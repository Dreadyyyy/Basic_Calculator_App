package com.example.basiccalculatorapp.ui

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basiccalculatorapp.data.CalculatorButton
import com.example.basiccalculatorapp.ui.utils.ButtonsPaneType
import com.example.basiccalculatorapp.model.CalculatorUiState
import com.example.basiccalculatorapp.ui.screens.CalculatorScreen
import com.example.basiccalculatorapp.ui.screens.CalculatorViewModel
import com.example.basiccalculatorapp.ui.utils.ButtonsFontSize

@Composable
fun BasicCalculatorApp(
    calculatorViewModel: CalculatorViewModel = viewModel(),
    windowSizeClass: WindowSizeClass
) {
    val calculatorUiState: State<CalculatorUiState> = calculatorViewModel.calculatorUiState.collectAsState()
    val buttonsPaneType: ButtonsPaneType =
        if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) ButtonsPaneType.Basic
        else ButtonsPaneType.Expanded
    val buttonsFontSize: ButtonsFontSize =
        if (windowSizeClass.heightSizeClass == WindowHeightSizeClass.Compact) ButtonsFontSize.Compact
        else ButtonsFontSize.Expanded
    CalculatorScreen(
        expression = calculatorUiState.value.shownExpression,
        result = calculatorUiState.value.result,
        buttonsPaneType = buttonsPaneType,
        buttonsFontSize = buttonsFontSize,
        onClickAction = { button: CalculatorButton -> calculatorViewModel.onButtonPressed(button) }
    )
}
