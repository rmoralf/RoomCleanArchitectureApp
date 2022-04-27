package com.rmoralf.roomcleanarchitectureapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rmoralf.roomcleanarchitectureapp.data.database.entitities.WeightEntity

@Dao
interface WeightDao {

    @Query("SELECT * FROM weight_table")
    suspend fun getAllWeights(): List<WeightEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weight: WeightEntity)

    @Query("DELETE FROM weight_table")
    suspend fun deleteAllWeights()
}