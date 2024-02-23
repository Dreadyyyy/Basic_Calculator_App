package com.example.basiccalculatorapp.data

sealed interface CalculatorButton {
    val buttonText: String
    class Symbol(override val buttonText: String): CalculatorButton
    class MathematicalFunction(
        override val buttonText: String,
        val expressionToShow: String,
        val expressionToEvaluate: String
    ): CalculatorButton

    data object Equals: CalculatorButton {
        override val buttonText: String = "="
    }
    data object Clear: CalculatorButton {
        override val buttonText: String = "C"
    }
    data object Backspace: CalculatorButton {
        override val buttonText: String = "<-"
    }
}