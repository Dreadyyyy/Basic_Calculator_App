package com.example.basiccalculatorapp.ui.screens.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccalculatorapp.data.CalculatorButton
import com.example.basiccalculatorapp.ui.utils.ButtonsFontSize

@Composable
fun CompactButtonsPane(
    buttonsFontSize: ButtonsFontSize,
    onClickAction: (CalculatorButton) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        val basicButtonModifier: Modifier = Modifier
            .clip(CircleShape)
            .fillMaxHeight()
            .padding(4.dp)
            .weight(1F)
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Clear to basicButtonModifier,
                CalculatorButton.OpeningBracket to basicButtonModifier,
                CalculatorButton.ClosingBracket to basicButtonModifier,
                CalculatorButton.Plus to basicButtonModifier,
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.One to basicButtonModifier,
                CalculatorButton.Two to basicButtonModifier,
                CalculatorButton.Three to basicButtonModifier,
                CalculatorButton.Minus to basicButtonModifier,
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Four to basicButtonModifier,
                CalculatorButton.Five to basicButtonModifier,
                CalculatorButton.Six to basicButtonModifier,
                CalculatorButton.Multiply to basicButtonModifier,
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Seven to basicButtonModifier,
                CalculatorButton.Eight to basicButtonModifier,
                CalculatorButton.Nine to basicButtonModifier,
                CalculatorButton.Divide to basicButtonModifier,
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Period to basicButtonModifier,
                CalculatorButton.Zero to basicButtonModifier,
                CalculatorButton.Comma to basicButtonModifier,
                CalculatorButton.Equals to basicButtonModifier,
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
    }
}

@Composable
fun ExpandedButtonsPane(
    buttonsFontSize: ButtonsFontSize,
    onClickAction: (CalculatorButton) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        val basicButtonModifier: Modifier = Modifier
            .clip(CircleShape)
            .fillMaxHeight()
            .padding(4.dp)
            .weight(1F)
        val biggerButtonModifier: Modifier = Modifier
            .clip(CircleShape)
            .fillMaxHeight()
            .padding(4.dp)
            .weight(2F)
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Clear to basicButtonModifier,
                CalculatorButton.E to basicButtonModifier,
                CalculatorButton.Pi to basicButtonModifier,
                CalculatorButton.Factorial to basicButtonModifier,
                CalculatorButton.One to basicButtonModifier,
                CalculatorButton.Two to basicButtonModifier,
                CalculatorButton.Three to basicButtonModifier,
                CalculatorButton.Plus to basicButtonModifier,
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.OpeningBracket to basicButtonModifier,
                CalculatorButton.Sin to basicButtonModifier,
                CalculatorButton.Cos to basicButtonModifier,
                CalculatorButton.Tan to basicButtonModifier,
                CalculatorButton.Four to basicButtonModifier,
                CalculatorButton.Five to basicButtonModifier,
                CalculatorButton.Six to basicButtonModifier,
                CalculatorButton.Minus to basicButtonModifier,
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.ClosingBracket to basicButtonModifier,
                CalculatorButton.PowerOf to basicButtonModifier,
                CalculatorButton.Sqrt to basicButtonModifier,
                CalculatorButton.Log to basicButtonModifier,
                CalculatorButton.Seven to basicButtonModifier,
                CalculatorButton.Eight to basicButtonModifier,
                CalculatorButton.Nine to basicButtonModifier,
                CalculatorButton.Multiply to basicButtonModifier,
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Equals to biggerButtonModifier,
                CalculatorButton.Ln to basicButtonModifier,
                CalculatorButton.Comma to basicButtonModifier,
                CalculatorButton.Zero to biggerButtonModifier,
                CalculatorButton.Period to basicButtonModifier,
                CalculatorButton.Divide to basicButtonModifier,
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
    }
}

@Composable
fun MediumButtonsPane(
    buttonsFontSize: ButtonsFontSize,
    onClickAction: (CalculatorButton) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        val basicButtonModifier: Modifier = Modifier
            .clip(CircleShape)
            .fillMaxHeight()
            .padding(4.dp)
            .weight(1F)
        val biggerButtonModifier: Modifier = Modifier
            .clip(CircleShape)
            .fillMaxHeight()
            .padding(4.dp)
            .weight(2F)
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Clear to biggerButtonModifier,
                CalculatorButton.OpeningBracket to biggerButtonModifier,
                CalculatorButton.ClosingBracket to biggerButtonModifier
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Sin to basicButtonModifier,
                CalculatorButton.Cos to basicButtonModifier,
                CalculatorButton.One to basicButtonModifier,
                CalculatorButton.Two to basicButtonModifier,
                CalculatorButton.Three to basicButtonModifier,
                CalculatorButton.Plus to basicButtonModifier
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Tan to basicButtonModifier,
                CalculatorButton.PowerOf to basicButtonModifier,
                CalculatorButton.Four to basicButtonModifier,
                CalculatorButton.Five to basicButtonModifier,
                CalculatorButton.Six to basicButtonModifier,
                CalculatorButton.Minus to basicButtonModifier
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.PowerOf to basicButtonModifier,
                CalculatorButton.Log to basicButtonModifier,
                CalculatorButton.Seven to basicButtonModifier,
                CalculatorButton.Eight to basicButtonModifier,
                CalculatorButton.Nine to basicButtonModifier,
                CalculatorButton.Multiply to basicButtonModifier
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Ln to basicButtonModifier,
                CalculatorButton.Factorial to basicButtonModifier,
                CalculatorButton.Comma to basicButtonModifier,
                CalculatorButton.Zero to biggerButtonModifier,
                CalculatorButton.Period to basicButtonModifier,
                CalculatorButton.Divide to basicButtonModifier
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
    }
}
@Composable
fun RowOfButtons(
    buttonsFontSize: ButtonsFontSize,
    onClickAction: (CalculatorButton) -> Unit,
    buttons: List<Pair<CalculatorButton, Modifier>>,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        buttons.forEach { (button: CalculatorButton, localModifier: Modifier)->
            Button(
                onClick = { onClickAction(button) },
                modifier = localModifier
            ) {
                Text(
                    text = button.calculatorButtonType.buttonText,
                    fontSize = when(buttonsFontSize) {
                        ButtonsFontSize.Compact -> 16.sp
                        ButtonsFontSize.Medium -> 20.sp
                        ButtonsFontSize.Expanded -> 32.sp
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrimaryButtonsPanePreview() {
    CompactButtonsPane(
        buttonsFontSize = ButtonsFontSize.Expanded,
        onClickAction = {_->},
        modifier = Modifier.fillMaxWidth()
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SecondaryButtonsPanePreview() {
    ExpandedButtonsPane(
        buttonsFontSize = ButtonsFontSize.Expanded,
        onClickAction = {_->},
        modifier = Modifier.fillMaxWidth()
    )
}
