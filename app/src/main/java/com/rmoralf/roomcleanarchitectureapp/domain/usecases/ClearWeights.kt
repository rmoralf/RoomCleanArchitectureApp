package com.rmoralf.roomcleanarchitectureapp.domain.usecases

import com.rmoralf.roomcleanarchitectureapp.domain.repository.RoomRepository

class ClearWeights(
    private val repository: RoomRepository
) {
    operator fun invoke() = repository.clearWeights()
}