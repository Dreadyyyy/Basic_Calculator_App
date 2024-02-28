package com.example.basiccalculatorapp.data
import android.content.Context

interface AppContainer {
    val expressionsRepository: ExpressionsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val expressionsRepository: ExpressionsRepository by lazy {
        OfflineExpressionsRepository(HistoryDatabase.getDatabase(context).expressionDao())
    }
}
