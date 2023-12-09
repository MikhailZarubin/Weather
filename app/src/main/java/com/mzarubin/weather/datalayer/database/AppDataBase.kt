package com.mzarubin.weather.datalayer.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mzarubin.weather.datamodel.LocalityEntity
import com.mzarubin.weather.datamodel.WeatherEntity

/**
 * Used to connect to the Local DataBase and get User data (Favorite Localities and Latest Measured Weather on it)
 */
@Database(entities = [LocalityEntity::class, WeatherEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun favoriteLocalitiesDao(): FavoriteLocalitiesDao

    abstract fun weatherLocalitiesDao(): WeatherLocalitiesDao
}
