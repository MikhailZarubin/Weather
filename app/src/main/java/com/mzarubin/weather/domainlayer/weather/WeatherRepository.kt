package com.mzarubin.weather.domainlayer.weather

import com.mzarubin.weather.domainlayer.datamodel.Location
import com.mzarubin.weather.domainlayer.datamodel.Response
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    /**
     * Return flow which contains response with WeatherDataModel or ErrorDataModel
     */
    fun getWeather(location: Location): Flow<Response>
}
