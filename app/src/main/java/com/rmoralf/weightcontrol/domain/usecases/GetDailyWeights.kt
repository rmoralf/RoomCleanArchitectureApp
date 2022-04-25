package com.rmoralf.weightcontrol.domain.usecases

import com.rmoralf.weightcontrol.domain.repository.RoomRepository


class GetDailyWeights(
    private val repository: RoomRepository
) {
    operator fun invoke() = repository.getDailyWeights()
}