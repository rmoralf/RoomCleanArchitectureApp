package com.rmoralf.roomcleanarchitectureapp.domain.usecases

data class UseCases(
    //Room
    val getDailyWeights: GetDailyWeights,
    val storeNewWeight: StoreNewWeight,
    val clearWeights: ClearWeights
)
