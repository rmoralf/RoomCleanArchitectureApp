package com.rmoralf.weightcontrol.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rmoralf.weightcontrol.data.database.dao.WeightDao
import com.rmoralf.weightcontrol.data.database.entitities.WeightEntity


@Database(entities = [WeightEntity::class], version = 1)
abstract class WeightDatabase : RoomDatabase() {

    abstract fun getWeightDao(): WeightDao
}