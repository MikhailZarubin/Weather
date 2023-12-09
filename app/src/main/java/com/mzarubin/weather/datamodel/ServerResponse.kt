package com.mzarubin.weather.datamodel

import com.google.gson.annotations.SerializedName

data class CountryDataModel(
    @field:SerializedName("country") val countryName: String,
    @field:SerializedName("cities") val citiesNameList: List<String>
)

data class CountriesResponse(
    @field:SerializedName("error") val error: Boolean,
    @field:SerializedName("msg") val message: String,
    @field:SerializedName("data") val data: List<CountryDataModel>
)

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
)
