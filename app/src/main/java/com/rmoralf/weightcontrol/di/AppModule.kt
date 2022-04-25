package com.rmoralf.weightcontrol.di

import android.content.Context
import androidx.room.Room
import com.rmoralf.weightcontrol.core.utils.Constants.ROOM_DB_NAME
import com.rmoralf.weightcontrol.data.database.WeightDatabase
import com.rmoralf.weightcontrol.data.database.dao.WeightDao
import com.rmoralf.weightcontrol.data.repositories.RoomRepositoryImpl
import com.rmoralf.weightcontrol.domain.repository.RoomRepository
import com.rmoralf.weightcontrol.domain.usecases.ClearWeights
import com.rmoralf.weightcontrol.domain.usecases.GetDailyWeights
import com.rmoralf.weightcontrol.domain.usecases.StoreNewWeight
import com.rmoralf.weightcontrol.domain.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Module
@ExperimentalCoroutinesApi
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, WeightDatabase::class.java, ROOM_DB_NAME).build()

    @Singleton
    @Provides
    fun provideWeightDao(db: WeightDatabase) = db.getWeightDao()

    @Provides
    fun provideRoomRepository(weightDao: WeightDao): RoomRepository = RoomRepositoryImpl(weightDao)

    @Provides
    fun provideUseCases(
        roomRepository: RoomRepository
    ) = UseCases(
        getDailyWeights = GetDailyWeights(roomRepository),
        storeNewWeight = StoreNewWeight(roomRepository),
        clearWeights = ClearWeights(roomRepository)
    )
}