package com.rmoralf.weightcontrol.data.database.entitities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rmoralf.weightcontrol.domain.model.Weight

@Entity(tableName = "weight_table")
data class WeightEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "weight") val weight: String
)

fun Weight.toDatabase() = WeightEntity(date = date, weight =  weight)
