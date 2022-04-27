package com.rmoralf.roomcleanarchitectureapp.domain.usecases

import com.rmoralf.roomcleanarchitectureapp.data.database.entitities.WeightEntity
import com.rmoralf.roomcleanarchitectureapp.domain.repository.RoomRepository


class StoreNewWeight(
    private val repository: RoomRepository
) {
    operator fun invoke(weight: WeightEntity) = repository.storeNewWeight(weight = weight)
}