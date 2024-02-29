package com.example.basiccalculatorapp

import android.util.Log
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.basiccalculatorapp.ui.screens.calculator.CalculatorViewModel
import com.example.basiccalculatorapp.ui.screens.history.HistoryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            Log.d("ViewModel", "Initializing calculator viewmodel")
            CalculatorViewModel(
                expressionsApplication().container.expressionsRepository
            )
        }
        initializer {
            HistoryViewModel(
                expressionsApplication().container.expressionsRepository
            )
        }
    }
}

fun CreationExtras.expressionsApplication(): ExpressionsApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ExpressionsApplication)
