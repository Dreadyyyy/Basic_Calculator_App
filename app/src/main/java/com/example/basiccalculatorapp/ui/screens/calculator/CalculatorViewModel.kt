package com.example.basiccalculatorapp.ui.screens.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basiccalculatorapp.data.ExpressionEntity
import com.example.basiccalculatorapp.data.ExpressionsRepository
import com.example.basiccalculatorapp.ui.utils.CalculatorButton
import com.example.basiccalculatorapp.ui.utils.CalculatorButtonType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.function.Function
import net.objecthunter.exp4j.operator.Operator
import kotlin.math.ln

class CalculatorViewModel(private val expressionsRepository: ExpressionsRepository) : ViewModel() {
    var calculatorUiState: MutableStateFlow<CalculatorUiState> = MutableStateFlow(
        CalculatorUiState()
    )
        private set
    private var expressionToShowAsStringList: MutableList<String> = mutableListOf()
    private var expressionToEvaluateAsStringList: MutableList<String> = mutableListOf()
    fun onButtonPressed(button: CalculatorButton) {
        when (button.calculatorButtonType) {
            is CalculatorButtonType.Symbol -> {
                expressionToShowAsStringList.add(button.calculatorButtonType.buttonText)
                expressionToEvaluateAsStringList.add(button.calculatorButtonType.buttonText)
            }

            is CalculatorButtonType.Operator -> {
                expressionToShowAsStringList.add(button.calculatorButtonType.buttonText)
                expressionToEvaluateAsStringList.add(button.calculatorButtonType.expressionToEvaluate)
            }

            is CalculatorButtonType.MathematicalFunction -> {
                expressionToShowAsStringList.add(button.calculatorButtonType.expressionToShow)
                expressionToEvaluateAsStringList.add(button.calculatorButtonType.expressionToEvaluate)
            }

            is CalculatorButtonType.Equals -> onEqualsPressed()
            is CalculatorButtonType.Clear -> onClearPressed()
            is CalculatorButtonType.Delete -> onDeletePressed()
        }
        updateCalculatorState()
    }

    private fun onEqualsPressed() {
        val newExpression: String = try {
            evaluateExpression()
        } catch (e: IllegalArgumentException) {
            showSnackbar(e.message ?: "Invalid expression")
            ""
        } catch (e: ArithmeticException) {
            showSnackbar(e.message ?: "Invalid expression")
            ""
        }

        if (newExpression != "") {
            addToHistory(
                expressionToShowAsStringList.joinToString(""),
                newExpression
            )
            expressionToShowAsStringList.clear()
            expressionToEvaluateAsStringList.clear()
            newExpression.forEach { digit: Char ->
                expressionToShowAsStringList.add(digit.toString())
                expressionToEvaluateAsStringList.add(digit.toString())
            }
        }
        updateCalculatorState()
    }
    private fun addToHistory(expression: String, result: String) {
        viewModelScope.launch {
            expressionsRepository.insertExpression(
                ExpressionEntity(
                    expression = expression,
                    result = result
                )
            )
        }
    }
    private fun showSnackbar(message: String) {
        updateCalculatorState(snackbarMessage = message)
    }

    fun dismissSnackbar() {
        updateCalculatorState(snackbarMessage = "")
    }

    private fun onClearPressed() {
        expressionToShowAsStringList.clear()
        expressionToEvaluateAsStringList.clear()
        updateCalculatorState()
    }

    private fun onDeletePressed() {
        expressionToShowAsStringList = expressionToShowAsStringList
            .slice(0..<expressionToShowAsStringList.lastIndex)
            .toMutableList()
        expressionToEvaluateAsStringList = expressionToEvaluateAsStringList
            .slice(0..<expressionToEvaluateAsStringList.lastIndex)
            .toMutableList()
        updateCalculatorState()
    }

    private fun updateCalculatorState() {
        val newResult: String = try {
            evaluateExpression()
        } catch (e: IllegalArgumentException) {
            ""
        } catch (e: ArithmeticException) {
            ""
        }
        calculatorUiState.update { currentState ->
            currentState.copy(
                shownExpression = expressionToShowAsStringList.joinToString(""),
                result = newResult
            )
        }
    }
    private fun updateCalculatorState(snackbarMessage: String) {
        calculatorUiState.update { currentState ->
            currentState.copy(
                snackbarMessage = snackbarMessage
            )
        }
    }

    private fun evaluateExpression(): String {
        val newExpression: String = expressionToEvaluateAsStringList.joinToString("")
        val result: String = ExpressionBuilder(newExpression)
            .function(logB)
            .operator(factorial)
            .variable("π")
            .build()
            .setVariable("π", kotlin.math.PI)
            .evaluate()
            .toString()
        return if (result != "NaN") result else ""
    }

    private companion object {
        private val factorial: Operator = object : Operator(
            "!",
            1,
            true,
            Operator.PRECEDENCE_POWER + 1
        ) {
            override fun apply(vararg p0: Double): Double {
                val arg: Int = p0[0].toInt()
                if (arg.toDouble() != p0[0]) {
                    throw IllegalArgumentException("The operand for factorial has to be an integer")
                }
                if (arg <= 0) {
                    throw IllegalArgumentException("The operand for factorial has to be grater than zero")
                }
                var result: Double = 1.0
                (2..arg).forEach { result *= it }
                return result
            }
        }

        private val logB: Function = object : Function("logB", 2) {
            override fun apply(vararg args: Double): Double {
                return ln(args[1]) / ln(args[0])
            }
        }
    }
}
