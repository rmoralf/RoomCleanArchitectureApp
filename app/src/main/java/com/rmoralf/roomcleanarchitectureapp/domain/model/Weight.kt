package com.rmoralf.roomcleanarchitectureapp.domain.model

import com.rmoralf.roomcleanarchitectureapp.data.database.entitities.WeightEntity

data class Weight(
    var date: String,
    var weight: String
)

fun WeightEntity.toDomain() = Weight(date = date, weight = weight)
