package com.example.basiccalculatorapp.ui

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.basiccalculatorapp.data.CalculatorUiState
import com.example.basiccalculatorapp.data.HistoryUiState
import com.example.basiccalculatorapp.ui.screens.CalculatorScreen
import com.example.basiccalculatorapp.ui.screens.CalculatorViewModel
import com.example.basiccalculatorapp.ui.screens.HistoryScreen
import com.example.basiccalculatorapp.ui.screens.content.HistoryViewModel
import com.example.basiccalculatorapp.ui.utils.ApplicationScreen
import com.example.basiccalculatorapp.ui.utils.ButtonsFontSize
import com.example.basiccalculatorapp.ui.utils.ButtonsPaneType
import kotlinx.coroutines.launch

@Composable
fun BasicCalculatorApp(
    navHostController: NavHostController = rememberNavController(),
    calculatorViewModel: CalculatorViewModel = viewModel(),
    historyViewModel: HistoryViewModel = viewModel(),
    windowSizeClass: WindowSizeClass
) {
    val calculatorUiState: State<CalculatorUiState> =
        calculatorViewModel.calculatorUiState.collectAsState()
    val historyUiState: State<HistoryUiState> =
        historyViewModel.historyUiState.collectAsState()
    val buttonsPaneType: ButtonsPaneType = when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> ButtonsPaneType.Compact
        WindowWidthSizeClass.Medium -> ButtonsPaneType.Medium
        WindowWidthSizeClass.Expanded -> ButtonsPaneType.Expanded
        else -> ButtonsPaneType.Compact
    }
    val buttonsFontSize: ButtonsFontSize = when (windowSizeClass.heightSizeClass) {
        WindowHeightSizeClass.Compact -> ButtonsFontSize.Compact
        WindowHeightSizeClass.Medium -> ButtonsFontSize.Medium
        WindowHeightSizeClass.Expanded -> ButtonsFontSize.Expanded
        else -> ButtonsFontSize.Compact
    }
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = ApplicationScreen.Calculator.name
        ) {
            composable(route = ApplicationScreen.Calculator.name) {
                CalculatorScreen(
                    expression = calculatorUiState.value.shownExpression,
                    result = calculatorUiState.value.result,
                    snackbarHostState = snackbarHostState,
                    snackbarMessage = calculatorUiState.value.snackbarMessage,
                    dismissSnackbar = calculatorViewModel::dismissSnackbar,
                    buttonsPaneType = buttonsPaneType,
                    buttonsFontSize = buttonsFontSize,
                    onClickAction = calculatorViewModel::onButtonPressed,
                    navigateToHistoryScreen = { navHostController.navigate(ApplicationScreen.History.name)},
                    contentPadding = innerPadding
                )
            }
            composable(route = ApplicationScreen.History.name) {
                HistoryScreen(
                    navigateUp = { navHostController.navigateUp() },
                    historyUiState = historyUiState.value
                )
            }
        }
    }
}
