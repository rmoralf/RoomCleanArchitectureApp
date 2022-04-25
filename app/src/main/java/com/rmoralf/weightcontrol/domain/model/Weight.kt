package com.rmoralf.weightcontrol.domain.model

import com.rmoralf.weightcontrol.data.database.entitities.WeightEntity

data class Weight(
    var date: String,
    var weight: String
)

fun WeightEntity.toDomain() = Weight(date = date, weight = weight)
