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
import com.example.basiccalculatorapp.data.CalculatorButtonType
import com.example.basiccalculatorapp.ui.screens.content.CompactButtonsPane
import com.example.basiccalculatorapp.ui.screens.content.ExpandedButtonsPane
import com.example.basiccalculatorapp.ui.screens.content.MediumButtonsPane
import com.example.basiccalculatorapp.ui.utils.ButtonsFontSize
import com.example.basiccalculatorapp.ui.utils.ButtonsPaneType

@Composable
fun CalculatorScreen(
    expression: String,
    result: String,
    buttonsPaneType: ButtonsPaneType,
    buttonsFontSize: ButtonsFontSize,
    onClickAction: (CalculatorButton) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = expression,
            fontSize =
                if (buttonsFontSize == ButtonsFontSize.Expanded) 48.sp
                else 40.sp,
            modifier = Modifier
                .weight(1F)
                .align(Alignment.End)
        )
        Text(
            text = result,
            fontSize =
                if (buttonsFontSize == ButtonsFontSize.Expanded) 36.sp
                else 28.sp,
            modifier = Modifier
                .weight(1F)
                .align(Alignment.End)
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { onClickAction(CalculatorButton.Delete) },
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(4.dp)
                    .height(44.dp)
            ) {
                Text(text = CalculatorButtonType.Delete.buttonText, fontSize = 20.sp)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.weight(4F)
        ) {
            when(buttonsPaneType) {
                ButtonsPaneType.Compact -> {
                    CompactButtonsPane(
                        buttonsFontSize = buttonsFontSize,
                        onClickAction = onClickAction,
                        modifier = Modifier.weight(1F)
                    )
                }
                ButtonsPaneType.Medium -> {
                    MediumButtonsPane(
                        buttonsFontSize = buttonsFontSize,
                        onClickAction = onClickAction,
                        modifier = Modifier.weight(1F)
                    )
                }
                ButtonsPaneType.Expanded -> {
                    ExpandedButtonsPane(
                        buttonsFontSize = buttonsFontSize,
                        onClickAction = onClickAction,
                        modifier = Modifier.weight(1F)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 1000, heightDp = 400)
@Composable
fun CalculatorScreenPreview() {
    CalculatorScreen(
        expression = "2 + 2 - 2 / 2 * 2",
        result = "2",
        buttonsPaneType = ButtonsPaneType.Expanded,
        buttonsFontSize = ButtonsFontSize.Compact,
        onClickAction = { _ -> }
    )
}