package com.mzarubin.weather.datalayer.datamodel

import com.google.gson.annotations.SerializedName

data class CountryServerModel(
    @field:SerializedName("country") val countryName: String,
    @field:SerializedName("cities") val citiesNameList: List<String>
)

data class CountriesResponse(
    @field:SerializedName("error") val error: Boolean,
    @field:SerializedName("msg") val message: String,
    @field:SerializedName("data") val countriesData: List<CountryServerModel>
)

data class LocationServerModel(
    @field:SerializedName("name") val name: String,
    @field:SerializedName("country") val country: String,
    @field:SerializedName("lat") val latitude: Double,
    @field:SerializedName("lon") val longitude: Double,
    @field:SerializedName("localtime") val currentTime: String
)

data class WeatherServerModel(
    @field:SerializedName("temp_c") val temperature: String,
    @field:SerializedName("last_updated") val measureTime: String
)

data class WeatherErrorServerModel(
    @field:SerializedName("code") val errorCode: Int,
    @field:SerializedName("message") val errorMessage: String
)

data class WeatherResponse(
    @field:SerializedName("location") val locationData: LocationServerModel?,
    @field:SerializedName("current") val weatherData: WeatherServerModel?,
    @field:SerializedName("error") val error: WeatherErrorServerModel?
)
