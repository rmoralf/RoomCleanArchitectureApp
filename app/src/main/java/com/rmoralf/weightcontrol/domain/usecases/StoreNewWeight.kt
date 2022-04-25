package com.rmoralf.weightcontrol.domain.usecases

import com.rmoralf.weightcontrol.data.database.entitities.WeightEntity
import com.rmoralf.weightcontrol.domain.repository.RoomRepository


class StoreNewWeight(
    private val repository: RoomRepository
) {
    operator fun invoke(weight: WeightEntity) = repository.storeNewWeight(weight = weight)
}