package com.mzarubin.weather.datalayer.network

import com.mzarubin.weather.datalayer.datamodel.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Used to connect to the Weather API to fetch weather info
 */
interface WeatherService {

    @GET("current.json")
    suspend fun fetchWeatherByLocality(@Query("q") localityName: String): WeatherResponse
}
