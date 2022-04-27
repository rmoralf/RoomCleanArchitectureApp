package com.rmoralf.roomcleanarchitectureapp.data.repositories

import com.rmoralf.roomcleanarchitectureapp.data.database.dao.WeightDao
import com.rmoralf.roomcleanarchitectureapp.data.database.entitities.WeightEntity
import com.rmoralf.roomcleanarchitectureapp.domain.model.Response.*
import com.rmoralf.roomcleanarchitectureapp.domain.model.toDomain
import com.rmoralf.roomcleanarchitectureapp.domain.repository.RoomRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ExperimentalCoroutinesApi
class RoomRepositoryImpl @Inject constructor(
    private val weightDao: WeightDao
) : RoomRepository {
    override fun getDailyWeights() = flow {
        try {
            emit(Loading)
            val store = weightDao.getAllWeights().map { it.toDomain() }
            emit(Success(store))
        } catch (e: Exception) {
            emit(Error(e.message ?: e.toString()))
        }
    }

    override fun storeNewWeight(weight: WeightEntity) = flow {
        try {
            emit(Loading)
            val store = weightDao.insert(weight)
            emit(Success(store))
        } catch (e: Exception) {
            emit(Error(e.message ?: e.toString()))
        }
    }

    override fun clearWeights() = flow {
        try {
            emit(Loading)
            val deletion = weightDao.deleteAllWeights()
            emit(Success(deletion))
        } catch (e: Exception) {
            emit(Error(e.message ?: e.toString()))
        }
    }
}