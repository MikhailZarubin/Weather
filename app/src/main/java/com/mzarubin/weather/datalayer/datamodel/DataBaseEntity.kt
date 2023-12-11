package com.mzarubin.weather.datalayer.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locality")
data class LocalityEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "country_name") val countryName: String,
    @ColumnInfo(name = "locality_name") val localityName: String
)

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo("temperature") val temperature: String,
    @ColumnInfo("measure_time") val measureTime: String,
    @ColumnInfo("update_time") val updateTime: String
)
