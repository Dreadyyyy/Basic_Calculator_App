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
    private var shownExpressionAsStringList: MutableList<String> = mutableListOf()
    private var evaluatedExpressionAsStringList: MutableList<String> = mutableListOf()
    fun onButtonPressed(symbol: String) {
        var newResult: String = ""
        var newShownExpression: String = ""
        when(symbol) {
            "=" -> {
                newResult = evaluateExpression()
                if (newResult != "") {
                    shownExpressionAsStringList = mutableListOf(newResult)
                    evaluatedExpressionAsStringList = mutableListOf(newResult)
                }
                newShownExpression = shownExpressionAsStringList.joinToString("")
                newResult = ""
            }
            "C" -> {
                shownExpressionAsStringList.clear()
                evaluatedExpressionAsStringList.clear()
                newShownExpression = ""
                newResult = ""
            }
            "<-" -> {
                shownExpressionAsStringList =
                    shownExpressionAsStringList.slice(0..<shownExpressionAsStringList.lastIndex)
                        .toMutableList()
                evaluatedExpressionAsStringList =
                    evaluatedExpressionAsStringList.slice(0..<evaluatedExpressionAsStringList.lastIndex)
                        .toMutableList()
                newShownExpression = shownExpressionAsStringList.joinToString("")
                newResult = evaluateExpression()
            }
            else -> {
                shownExpressionAsStringList.add(symbol)
                evaluatedExpressionAsStringList.add(symbol)
                newShownExpression = shownExpressionAsStringList.joinToString("")
                newResult = evaluateExpression()
            }
        }
        updateCalculatorState(newShownExpression, newResult)
    }
    private fun updateCalculatorState(newShownExpression: String, newResult: String) {
        calculatorUiState.update { currentState->
            currentState.copy(
                shownExpression = newShownExpression,
                result = newResult
            )
        }
    }
    private fun evaluateExpression(): String {
        val newExpression: String = evaluatedExpressionAsStringList.joinToString("")
        val logB: Function = object : Function("logB", 2) {
            override fun apply(vararg args: Double): Double {
                return ln(args[1]) / ln(args[0])
            }
        }
        val result: String = try {
            ExpressionBuilder(newExpression)
                .function(logB)
                .variable("π")
                .build()
                .setVariable("π", kotlin.math.PI)
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
