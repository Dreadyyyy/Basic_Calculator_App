package com.example.basiccalculatorapp.ui.test

import com.example.basiccalculatorapp.ui.utils.CalculatorButton
import com.example.basiccalculatorapp.ui.screens.calculator.CalculatorUiState
import com.example.basiccalculatorapp.ui.screens.calculator.CalculatorViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CalculatorViewModelTest {
    private val viewModel: CalculatorViewModel = CalculatorViewModel()


    @Test
    fun calculatorViewModel_triedToEvaluateInvalidExpression_expressionAndResultUnchangedErrorMessageUpdated() {
        viewModel.onButtonPressed(CalculatorButton.Two)
        viewModel.onButtonPressed(CalculatorButton.Divide)
        viewModel.onButtonPressed(CalculatorButton.Zero)
        viewModel.onButtonPressed(CalculatorButton.Equals)
        assertEquals(
            CalculatorUiState("2÷0", "", "Division by zero!"),
            viewModel.calculatorUiState.value
        )
    }

    @Test
    fun calculatorViewModel_functionsEntered_expressionAndResultChangedExpectedly() {
        viewModel.onButtonPressed(CalculatorButton.Log)
        viewModel.onButtonPressed(CalculatorButton.Ln)
        viewModel.onButtonPressed(CalculatorButton.Sqrt)
        viewModel.onButtonPressed(CalculatorButton.E)
        viewModel.onButtonPressed(CalculatorButton.PowerOf)
        viewModel.onButtonPressed(CalculatorButton.Four)
        viewModel.onButtonPressed(CalculatorButton.ClosingBracket)
        viewModel.onButtonPressed(CalculatorButton.ClosingBracket)
        viewModel.onButtonPressed(CalculatorButton.ClosingBracket)
        viewModel.onButtonPressed(CalculatorButton.Comma)
        viewModel.onButtonPressed(CalculatorButton.Four)
        viewModel.onButtonPressed(CalculatorButton.ClosingBracket)
        assertEquals(
            CalculatorUiState("logₓy(ln(sqrt(e^(4))),4)", "2.0"),
            viewModel.calculatorUiState.value
        )
    }
}