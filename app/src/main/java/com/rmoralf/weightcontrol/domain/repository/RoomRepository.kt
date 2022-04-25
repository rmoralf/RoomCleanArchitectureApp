package com.rmoralf.weightcontrol.domain.repository

import com.rmoralf.weightcontrol.data.database.entitities.WeightEntity
import com.rmoralf.weightcontrol.domain.model.Response
import com.rmoralf.weightcontrol.domain.model.Weight
import kotlinx.coroutines.flow.Flow

interface RoomRepository {
    fun getDailyWeights(): Flow<Response<List<Weight>>>
    fun storeNewWeight(weight: WeightEntity): Flow<Response<Unit>>
    fun clearWeights(): Flow<Response<Unit>>
}