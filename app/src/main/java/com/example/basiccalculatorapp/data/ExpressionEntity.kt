package com.example.basiccalculatorapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expressions")
data class ExpressionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val expression: String,
    val result: String
)
