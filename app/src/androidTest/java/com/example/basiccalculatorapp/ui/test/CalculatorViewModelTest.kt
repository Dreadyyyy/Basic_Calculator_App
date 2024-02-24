package com.example.basiccalculatorapp.ui.test

import com.example.basiccalculatorapp.data.CalculatorButton
import com.example.basiccalculatorapp.model.CalculatorUiState
import com.example.basiccalculatorapp.ui.screens.CalculatorViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CalculatorViewModelTest {
    private val viewModel: CalculatorViewModel = CalculatorViewModel()

    @Test
    fun calculatorViewModel_triedToEvaluateInvalidExpression_expressionAndResultUnchanged() {
        viewModel.onButtonPressed(CalculatorButton.Symbol("2"))
        viewModel.onButtonPressed(CalculatorButton.Symbol("/"))
        viewModel.onButtonPressed(CalculatorButton.Symbol("0"))
        viewModel.onButtonPressed(CalculatorButton.Equals)
        assertEquals(viewModel.calculatorUiState.value, CalculatorUiState("2/0", ""))
    }

    @Test
    fun calculatorViewModel_functionsEntered_expressionAndResultChangedExpectedly() {
        viewModel.onButtonPressed(
            CalculatorButton.MathematicalFunction(
                "logₓy",
                "logₓy(",
                "logB("
            )
        )
        viewModel.onButtonPressed(
            CalculatorButton.MathematicalFunction(
                "ln",
                "ln(",
                "log("
            )
        )
        viewModel.onButtonPressed(
            CalculatorButton.MathematicalFunction(
                "sqrt",
                "sqrt(",
                "sqrt("
            )
        )
        viewModel.onButtonPressed(CalculatorButton.Symbol("e"))
        viewModel.onButtonPressed(
            CalculatorButton.MathematicalFunction(
                "xʸ",
                "^(",
                "^("
            )
        )

        viewModel.onButtonPressed(CalculatorButton.Symbol("4"))
        viewModel.onButtonPressed(CalculatorButton.Symbol(")"))
        viewModel.onButtonPressed(CalculatorButton.Symbol(")"))
        viewModel.onButtonPressed(CalculatorButton.Symbol(")"))
        viewModel.onButtonPressed(CalculatorButton.Symbol(","))
        viewModel.onButtonPressed(CalculatorButton.Symbol("4"))
        viewModel.onButtonPressed(CalculatorButton.Symbol(")"))
        assertEquals(CalculatorUiState("logₓy(ln(sqrt(e^(4))),4)", "2.0"), viewModel.calculatorUiState.value)
    }
}