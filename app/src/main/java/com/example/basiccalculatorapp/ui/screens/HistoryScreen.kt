package com.example.basiccalculatorapp.ui.screens

import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.basiccalculatorapp.data.HistoryUiState

@Composable
fun HistoryScreen(
    navigateUp: () -> Unit,
    historyUiState: HistoryUiState,
) {
    Scaffold(
        topBar = { HistoryTopAppBar(navigateUp) }
    ) {contentPadding->
        LazyColumn(
            modifier = Modifier.padding(contentPadding)
        ) {
            items(
                historyUiState.expressions,
                { expression: String -> expression.hashCode() }
            ) { expression: String ->
                Text(text = expression)
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