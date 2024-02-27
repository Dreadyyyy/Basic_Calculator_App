package com.example.basiccalculatorapp.ui.utils

sealed interface CalculatorButtonType {
    val buttonText: String

    class Symbol(override val buttonText: String) :
        CalculatorButtonType

    class Operator(override val buttonText: String, val expressionToEvaluate: String = buttonText) :
        CalculatorButtonType

    class MathematicalFunction(
        override val buttonText: String,
        val expressionToShow: String = buttonText,
        val expressionToEvaluate: String = expressionToShow
    ) : CalculatorButtonType

    data object Equals : CalculatorButtonType {
        override val buttonText: String = "="
    }

    data object Clear : CalculatorButtonType {
        override val buttonText: String = "C"
    }

    data object Delete : CalculatorButtonType {
        override val buttonText: String = "del"
    }
}

enum class CalculatorButton(val calculatorButtonType: CalculatorButtonType) {
    One(CalculatorButtonType.Symbol("1")),
    Two(CalculatorButtonType.Symbol("2")),
    Three(CalculatorButtonType.Symbol("3")),
    Four(CalculatorButtonType.Symbol("4")),
    Five(CalculatorButtonType.Symbol("5")),
    Six(CalculatorButtonType.Symbol("6")),
    Seven(CalculatorButtonType.Symbol("7")),
    Eight(CalculatorButtonType.Symbol("8")),
    Nine(CalculatorButtonType.Symbol("9")),
    OpeningBracket(CalculatorButtonType.Symbol("(")),
    ClosingBracket(CalculatorButtonType.Symbol(")")),
    Zero(CalculatorButtonType.Symbol("0")),
    E(CalculatorButtonType.Symbol("e")),
    Pi(CalculatorButtonType.Symbol("π")),
    Plus(CalculatorButtonType.Operator("+")),
    Minus(CalculatorButtonType.Operator("-")),
    Multiply(CalculatorButtonType.Operator("x", "⋅")),
    Divide(CalculatorButtonType.Operator("÷", "/")),
    Comma(CalculatorButtonType.Symbol(",")),
    Period(CalculatorButtonType.Symbol(".")),
    Sin(
        CalculatorButtonType.MathematicalFunction(
            "sin",
            "sin("
        )
    ),
    Cos(
        CalculatorButtonType.MathematicalFunction(
            "cos",
            "cos("
        )
    ),
    Tan(
        CalculatorButtonType.MathematicalFunction(
            "tan",
            "tan("
        )
    ),
    Log(
        CalculatorButtonType.MathematicalFunction(
            "logₓy",
            "logₓy(",
            "logB("
        )
    ),
    Ln(
        CalculatorButtonType.MathematicalFunction(
            "ln",
            "ln(",
            "log("
        )
    ),
    PowerOf(CalculatorButtonType.MathematicalFunction("xʸ", "^(")),
    Sqrt(
        CalculatorButtonType.MathematicalFunction(
            "sqrt",
            "sqrt("
        ),
    ),
    Factorial(CalculatorButtonType.Operator("!")),
    Clear(CalculatorButtonType.Clear),
    Delete(CalculatorButtonType.Delete),
    Equals(CalculatorButtonType.Equals);
}