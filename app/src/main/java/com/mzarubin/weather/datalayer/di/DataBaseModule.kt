package com.mzarubin.weather.datalayer.di

import android.app.Application
import androidx.room.Room
import com.mzarubin.weather.datalayer.database.AppDataBase
import com.mzarubin.weather.datalayer.database.FavoriteLocalitiesAcceptorDao
import com.mzarubin.weather.datalayer.database.FavoriteLocalitiesSourceDao
import com.mzarubin.weather.datalayer.database.WeatherLocalitiesAcceptorDao
import com.mzarubin.weather.datalayer.database.WeatherLocalitiesSourceDao
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

    @Provides
    @Singleton
    fun provideWeatherLocalitiesAcceptorDao(appDataBase: AppDataBase): WeatherLocalitiesAcceptorDao {
        return appDataBase.weatherLocalitiesAcceptorDao()
    }

    @Provides
    @Singleton
    fun provideWeatherLocalitiesSourceDao(appDataBase: AppDataBase): WeatherLocalitiesSourceDao {
        return appDataBase.weatherLocalitiesSourceDao()
    }

    @Provides
    @Singleton
    fun provideFavoriteLocalitiesAcceptorDao(appDataBase: AppDataBase): FavoriteLocalitiesAcceptorDao {
        return appDataBase.favoriteLocalitiesAcceptorDao()
    }

    @Provides
    @Singleton
    fun provideFavoriteLocalitiesSourceDao(appDataBase: AppDataBase): FavoriteLocalitiesSourceDao {
        return appDataBase.favoriteLocalitiesSourceDao()
    }
}
