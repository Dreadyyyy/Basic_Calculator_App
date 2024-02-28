package com.example.basiccalculatorapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpressionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(expressionEntity: ExpressionEntity)
    @Delete
    suspend fun delete(expressionEntity: ExpressionEntity)
    @Query("SELECT * FROM expressions")
    fun getAllExpressionEntities(): Flow<List<ExpressionEntity>>
}