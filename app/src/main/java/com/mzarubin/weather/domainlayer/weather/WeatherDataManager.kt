package com.mzarubin.weather.domainlayer.weather

import com.mzarubin.weather.domainlayer.datamodel.WeatherDataModel

interface WeatherDataManager {

    suspend fun addWeatherLocality(weatherDataModel: WeatherDataModel)

    suspend fun deleteWeatherLocality(weatherDataModel: WeatherDataModel)
}
