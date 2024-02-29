package com.example.basiccalculatorapp

import android.app.Application
import com.example.basiccalculatorapp.data.AppContainer
import com.example.basiccalculatorapp.data.AppDataContainer

class ExpressionsApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}


//import android.app.Application
//import com.example.inventory.data.AppContainer
//import com.example.inventory.data.AppDataContainer
//
//class InventoryApplication : Application() {
//
//    /**
//     * AppContainer instance used by the rest of classes to obtain dependencies
//     */
//    lateinit var container: AppContainer
//
//    override fun onCreate() {
//        super.onCreate()
//        container = AppDataContainer(this)
//    }
//}
