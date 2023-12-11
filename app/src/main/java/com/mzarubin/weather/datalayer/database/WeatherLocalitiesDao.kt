package com.mzarubin.weather.datalayer.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mzarubin.weather.datalayer.datamodel.WeatherEntity

@Dao
interface WeatherLocalitiesAcceptorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherLocality(weatherEntity: WeatherEntity)

    @Delete
    fun deleteWeatherLocality(weatherEntity: WeatherEntity): Int
}

@Dao
interface WeatherLocalitiesSourceDao {

    @Query("SELECT * FROM weather WHERE uid LIKE :localityId LIMIT 1")
    fun getWeatherByLocalityId(localityId: Int): WeatherEntity
}
