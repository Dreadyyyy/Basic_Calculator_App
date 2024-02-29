package com.example.basiccalculatorapp.ui.screens.history

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.basiccalculatorapp.data.ExpressionEntity


@Composable
fun HistoryScreen(
    navigateUp: () -> Unit,
    historyUiState: HistoryUiState,
) {
    Scaffold(
        topBar = { HistoryTopAppBar(navigateUp) }
    ) { contentPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            items(
                historyUiState.expressions,
                { expression: ExpressionEntity -> expression.hashCode() }
            ) { expression: ExpressionEntity ->
                Text(
                    text = "${expression.expression}=${expression.result}",
                    fontSize = 24.sp
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryTopAppBar(
    navigateUp: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "History") },
        navigationIcon = {
            IconButton(onClick = navigateUp) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        }
    )
}