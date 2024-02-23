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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PrimaryButtonsPane(
    onClickAction: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        RowOfButtons(
            onClickAction = onClickAction,
            buttons = listOf(
                "C" to "C",
                "(" to "(",
                ")" to ")",
                "+" to "+"
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            onClickAction = onClickAction,
            buttons = listOf(
                "1" to "1",
                "2" to "2",
                "3" to "3",
                "-" to "-"
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            onClickAction = onClickAction,
            buttons = listOf(
                "4" to "4",
                "5" to "5",
                "6" to "6",
                "*" to "*"
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            onClickAction = onClickAction,
            buttons = listOf(
                "7" to "7",
                "8" to "8",
                "9" to "9",
                "/" to "/"
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            onClickAction = onClickAction,
            buttons = listOf(
                "." to ".",
                "0" to "0",
                "," to ",",
                "=" to "="
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
    }
}

@Composable
fun SecondaryButtonsPane(
    onClickAction: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        RowOfButtons(
            onClickAction = onClickAction,
            buttons = listOf(
                "sin" to "sin(",
                "cos" to "cos(",
                "tan" to "tan("
            ),
            modifier = Modifier.weight(1F)
            )
        RowOfButtons(
            onClickAction = onClickAction,
            buttons = listOf(
                "sqrt" to "sqrt(",
                "xʸ" to "^(",
                "ln" to "log("
            ),
            modifier = Modifier.weight(1F)
            )
        RowOfButtons(
            onClickAction = onClickAction,
            buttons = listOf(
                "logₓy" to ("logB("),
                "e" to "e",
                "π" to "π"
            ),
            modifier = Modifier.weight(1F)
        )
    }
}
@Composable
fun RowOfButtons(
    onClickAction: (String) -> Unit,
    buttons: List<Pair<String, String>>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        buttons.forEach { (symbol: String, toPrint: String)->
            Button(
                onClick = { onClickAction(toPrint) },
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(4.dp)
                    .weight(1F)
                    .fillMaxHeight()
            ) {
//                Text(text = symbol, fontSize = 32.sp)
                AutoResizedText(text = symbol, initialFontSize = 36.sp)
            }
        }
    }
}

@Composable
fun AutoResizedText(text: String, initialFontSize: TextUnit) {
    var resizedFontSize: TextUnit by remember {
        mutableStateOf(initialFontSize)
    }
    var shouldDraw: Boolean by remember {
        mutableStateOf(false)
    }
    var fontSizeLowered: Boolean by remember {
        mutableStateOf(false)
    }
    Text(
        text = text,
        fontSize = resizedFontSize,
        onTextLayout = {result->
           if (result.didOverflowHeight && !fontSizeLowered) {
               resizedFontSize = 20.sp
               fontSizeLowered = true
           } else if (result.didOverflowHeight) {
               resizedFontSize *= 0.95
           } else shouldDraw = true
        },
        modifier = Modifier.drawWithContent { if (shouldDraw) drawContent() }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrimaryButtonsPanePreview() {
    PrimaryButtonsPane(
        onClickAction = {_->},
        modifier = Modifier.fillMaxWidth()
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SecondaryButtonsPanePreview() {
    SecondaryButtonsPane(
        onClickAction = {_->},
        modifier = Modifier.fillMaxWidth()
    )
}
