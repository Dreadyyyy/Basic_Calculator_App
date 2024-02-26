package com.example.basiccalculatorapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basiccalculatorapp.data.CalculatorButton
import com.example.basiccalculatorapp.data.CalculatorUiState
import com.example.basiccalculatorapp.ui.screens.CalculatorScreen
import com.example.basiccalculatorapp.ui.screens.CalculatorViewModel
import com.example.basiccalculatorapp.ui.utils.ButtonsFontSize
import com.example.basiccalculatorapp.ui.utils.ButtonsPaneType
import kotlinx.coroutines.launch

@Composable
fun BasicCalculatorApp(
    calculatorViewModel: CalculatorViewModel = viewModel(),
    windowSizeClass: WindowSizeClass
) {
    val calculatorUiState: State<CalculatorUiState> = calculatorViewModel.calculatorUiState.collectAsState()
    val buttonsPaneType: ButtonsPaneType = when(windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> ButtonsPaneType.Compact
        WindowWidthSizeClass.Medium -> ButtonsPaneType.Medium
        WindowWidthSizeClass.Expanded -> ButtonsPaneType.Expanded
        else -> ButtonsPaneType.Compact
    }
    val buttonsFontSize: ButtonsFontSize = when(windowSizeClass.heightSizeClass) {
        WindowHeightSizeClass.Compact -> ButtonsFontSize.Compact
        WindowHeightSizeClass.Medium -> ButtonsFontSize.Medium
        WindowHeightSizeClass.Expanded -> ButtonsFontSize.Expanded
        else -> ButtonsFontSize.Compact
    }
    calculatorViewModel.scope = rememberCoroutineScope()
    calculatorViewModel.snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = calculatorViewModel.snackbarHostState)
        }
    ) {innerPadding->
        CalculatorScreen(
            expression = calculatorUiState.value.shownExpression,
            result = calculatorUiState.value.result,
            buttonsPaneType = buttonsPaneType,
            buttonsFontSize = buttonsFontSize,
            onClickAction = { button: CalculatorButton -> calculatorViewModel.onButtonPressed(button) },
            contentPadding = innerPadding
        )
    }
}
