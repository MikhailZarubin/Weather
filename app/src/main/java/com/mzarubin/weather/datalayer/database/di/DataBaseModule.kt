package com.mzarubin.weather.datalayer.database.di

import android.app.Application
import androidx.room.Room
import com.mzarubin.weather.datalayer.database.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideAppDataBase(application: Application): AppDataBase {
        return Room.databaseBuilder(
            application.applicationContext,
            AppDataBase::class.java, "weather_app_database"
        ).build()
    }
}
