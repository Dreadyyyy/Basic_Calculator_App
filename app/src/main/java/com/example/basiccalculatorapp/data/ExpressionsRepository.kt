package com.example.basiccalculatorapp.data

import kotlinx.coroutines.flow.Flow

interface ExpressionsRepository {
    fun getAllItemStream(): Flow<List<ExpressionEntity>>
    suspend fun insertExpression(expressionEntity: ExpressionEntity)
    suspend fun deleteExpression(expressionEntity: ExpressionEntity)
}