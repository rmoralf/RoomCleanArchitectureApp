package com.rmoralf.weightcontrol.domain.usecases

import com.rmoralf.weightcontrol.domain.repository.RoomRepository

class ClearWeights(
    private val repository: RoomRepository
) {
    operator fun invoke() = repository.clearWeights()
}