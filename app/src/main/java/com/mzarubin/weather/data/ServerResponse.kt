package com.mzarubin.weather.data

import com.google.gson.annotations.SerializedName

sealed class ServerResponse

data class LocationDataModel(
    @field:SerializedName("name") val name: String,
    @field:SerializedName("country") val country: String,
    @field:SerializedName("lat") val latitude: Double,
    @field:SerializedName("lon") val longitude: Double,
    @field:SerializedName("localtime") val currentTime: String
)

data class WeatherDataModel(
    @field:SerializedName("temp_c") val temperature: String,
    @field:SerializedName("last_updated") val measureTime: String
)

data class WeatherResponse(
    @field:SerializedName("location") val locationDataModel: LocationDataModel,
    @field:SerializedName("current") val weatherDataModel: WeatherDataModel
) : ServerResponse()
