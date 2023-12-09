package com.mzarubin.weather.domain.network

import com.mzarubin.weather.data.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Used to connect to the Weather API to fetch weather info
 */
interface WeatherService {

    @GET("current.json")
    suspend fun getWeatherByLocality(@Query("q") localityName: String): WeatherResponse
}
