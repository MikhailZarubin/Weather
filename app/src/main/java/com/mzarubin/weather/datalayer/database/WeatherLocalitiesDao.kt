package com.mzarubin.weather.datalayer.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mzarubin.weather.datamodel.WeatherEntity

@Dao
interface WeatherLocalitiesDao {

    @Insert
    fun insertWeatherLocality(weatherEntity: WeatherEntity)

    @Delete
    fun deleteWeatherLocality(weatherEntity: WeatherEntity): Int

    @Update
    fun updateWeatherLocality(weatherEntity: WeatherEntity): Int

    @Query("SELECT * FROM weather WHERE uid LIKE :localityId LIMIT 1")
    fun getWeatherByLocalityId(localityId: Int): WeatherEntity
}
