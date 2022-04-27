package com.rmoralf.roomcleanarchitectureapp.domain.repository

import com.rmoralf.roomcleanarchitectureapp.data.database.entitities.WeightEntity
import com.rmoralf.roomcleanarchitectureapp.domain.model.Response
import com.rmoralf.roomcleanarchitectureapp.domain.model.Weight
import kotlinx.coroutines.flow.Flow

interface RoomRepository {
    fun getDailyWeights(): Flow<Response<List<Weight>>>
    fun storeNewWeight(weight: WeightEntity): Flow<Response<Unit>>
    fun clearWeights(): Flow<Response<Unit>>
}