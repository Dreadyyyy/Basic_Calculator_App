package com.example.basiccalculatorapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ExpressionEntity::class], version = 1, exportSchema = false)
abstract class HistoryDatabase : RoomDatabase() {
    abstract fun expressionDao(): ExpressionDao

    companion object {
        @Volatile
        private var Instance: HistoryDatabase? = null
        fun getDatabase(context: Context): HistoryDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, HistoryDatabase::class.java, "expression_database")
                    .fallbackToDestructiveMigration().build().also { Instance = it }
            }
        }
    }
}