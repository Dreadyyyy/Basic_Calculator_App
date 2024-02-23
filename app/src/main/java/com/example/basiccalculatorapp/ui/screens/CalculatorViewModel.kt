package com.example.basiccalculatorapp.ui.screens

import androidx.compose.animation.core.updateTransition
import androidx.lifecycle.ViewModel
import com.example.basiccalculatorapp.data.CalculatorButton
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
    private var expressionToShowAsStringList: MutableList<String> = mutableListOf()
    private var expressionToEvaluateAsStringList: MutableList<String> = mutableListOf()
    fun onButtonPressed(button: CalculatorButton) {
        when(button) {
            is CalculatorButton.Symbol -> {
                expressionToShowAsStringList.add(button.buttonText)
                expressionToEvaluateAsStringList.add(button.buttonText)
            }
            is CalculatorButton.MathematicalFunction -> {
                expressionToShowAsStringList.add(button.expressionToShow)
                expressionToEvaluateAsStringList.add(button.expressionToEvaluate)
            }
            is CalculatorButton.Equals -> onEqualsPressed()
            is CalculatorButton.Clear -> onClearPressed()
            is CalculatorButton.Backspace -> onBackspacePressed()
        }
        updateCalculatorState()
    }
    private fun onEqualsPressed() {
        val newExpression: String = evaluateExpression()
        if (newExpression != "") {
            expressionToShowAsStringList.clear()
            expressionToEvaluateAsStringList.clear()
            newExpression.forEach { digit: Char ->
                expressionToShowAsStringList.add(digit.toString())
                expressionToEvaluateAsStringList.add(digit.toString())
            }
        }
        updateCalculatorState()
    }
    private fun onClearPressed() {
        expressionToShowAsStringList.clear()
        expressionToEvaluateAsStringList.clear()
        updateCalculatorState()
    }
    private fun onBackspacePressed() {
        expressionToShowAsStringList = expressionToShowAsStringList
            .slice(0..<expressionToShowAsStringList.lastIndex)
            .toMutableList()
        expressionToEvaluateAsStringList = expressionToEvaluateAsStringList
            .slice(0..<expressionToEvaluateAsStringList.lastIndex)
            .toMutableList()
        updateCalculatorState()
    }
    
    private fun updateCalculatorState() {
        calculatorUiState.update { currentState->
            currentState.copy(
                shownExpression = expressionToShowAsStringList.joinToString(""),
                result = evaluateExpression()
            )
        }
    }
    private fun evaluateExpression(): String {
        val newExpression: String = expressionToEvaluateAsStringList.joinToString("")
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
