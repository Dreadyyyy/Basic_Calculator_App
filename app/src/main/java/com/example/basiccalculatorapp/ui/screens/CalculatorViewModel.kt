package com.example.basiccalculatorapp.ui.screens

import androidx.lifecycle.ViewModel
import com.example.basiccalculatorapp.model.CalculatorUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.function.Function
import java.lang.ArithmeticException
import java.lang.IllegalArgumentException
import kotlin.math.ln

class CalculatorViewModel: ViewModel() {
    var calculatorUiState: MutableStateFlow<CalculatorUiState> = MutableStateFlow(
        CalculatorUiState()
    )
        private set
    fun onButtonPressed(symbol: String) {
        var newExpression: String = calculatorUiState.value.expression
        var newResult: String
        when(symbol) {
            "=" -> {
                newResult = evaluateExpression(newExpression)
                newExpression = if (newResult != "") newResult else newExpression
                newResult = ""
            }
            "C" -> {
                newExpression = ""
                newResult = ""
            }
            "<-" -> {
                newExpression = newExpression.slice(0..<newExpression.lastIndex)
                newResult = evaluateExpression(newExpression)
            }
            else -> {
                newExpression += symbol
                newResult = evaluateExpression(newExpression)
            }
        }
        updateCalculatorState(newExpression, newResult)
    }
    private fun updateCalculatorState(newExpression: String, newResult: String) {
        calculatorUiState.update { currentState->
            currentState.copy(
                expression = newExpression,
                result = newResult
            )
        }
    }
    private fun evaluateExpression(expression: String): String {
        val logB: Function = object : Function("logB", 2) {
            override fun apply(vararg args: Double): Double {
                return ln(args[1]) / ln(args[0])
            }
        }
        val result: String = try {
            ExpressionBuilder(expression)
                .function(logB)
                .build()
                .evaluate()
                .toString()
        } catch (e: IllegalArgumentException) {
            ""
        } catch (e: ArithmeticException) {
            ""
        }
        return if (result != "NaN") result else ""
    }
}
