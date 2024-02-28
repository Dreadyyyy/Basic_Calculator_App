package com.example.basiccalculatorapp.data

import kotlinx.coroutines.flow.Flow

class OfflineExpressionsRepository(private val expressionDao: ExpressionDao) :
    ExpressionsRepository {
    override fun getAllItemStream(): Flow<List<ExpressionEntity>> {
        return expressionDao.getAllExpressionEntities()
    }

    override suspend fun insertExpression(expressionEntity: ExpressionEntity) {
        expressionDao.insert(expressionEntity)
    }

    override suspend fun deleteExpression(expressionEntity: ExpressionEntity) {
        expressionDao.delete(expressionEntity)
    }

}