package com.example.basiccalculatorapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.basiccalculatorapp.ui.screens.content.AutoResizedText
import com.example.basiccalculatorapp.ui.screens.content.PrimaryButtonsPane
import com.example.basiccalculatorapp.ui.screens.content.SecondaryButtonsPane
import com.example.basiccalculatorapp.ui.utils.ButtonsPaneType

@Composable
fun CalculatorScreen(
    expression: String,
    result: String,
    buttonsPaneType: ButtonsPaneType,
    onClickAction: (CalculatorButton) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = expression,
            fontSize = 48.sp,
            modifier = Modifier
                .weight(1F)
                .align(Alignment.End)
        )
        Text(
            text = result,
            fontSize = 36.sp,
            modifier = Modifier
                .weight(1F)
                .align(Alignment.End)
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { onClickAction(CalculatorButton.Backspace) },
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(4.dp)
                    .height(44.dp)
            ) {
                AutoResizedText(text = CalculatorButton.Backspace.buttonText, initialFontSize = 20.sp)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.weight(4F)
        ) {
            if (buttonsPaneType == ButtonsPaneType.Expanded) {
                SecondaryButtonsPane(
                    onClickAction = onClickAction,
                    modifier = Modifier.weight(1F)
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            PrimaryButtonsPane(
                onClickAction = onClickAction,
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun CalculatorScreenPreview() {
    CalculatorScreen(
        expression = "2 + 2 - 2 / 2 * 2",
        result = "2",
        buttonsPaneType = ButtonsPaneType.Basic,
        onClickAction = { _ -> }
    )
}