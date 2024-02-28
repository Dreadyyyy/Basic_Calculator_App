package com.example.basiccalculatorapp.ui

import android.app.Application
import android.util.Log
import com.example.basiccalculatorapp.data.AppContainer
import com.example.basiccalculatorapp.data.AppDataContainer
import com.example.basiccalculatorapp.ui.utils.CalculatorButton

class ExpressionsApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}


