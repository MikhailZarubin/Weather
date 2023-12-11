package com.mzarubin.weather.domainlayer.datamodel

sealed class Response

data class CountryDataModel(
    val countryName: String,
    val localities: LocalitiesDataModel
) : Response()

data class CountriesDataModel(
    val countries: List<CountryDataModel>
) : Response()

sealed class Location : Response()

data class CoordinatesDataModel(
    val latitude: Double,
    val longitude: Double
) : Location()

data class LocalityDataModel(
    val countryName: String,
    val localityName: String
) : Location()

data class LocalitiesDataModel(
    val localities: List<LocalityDataModel>
) : Response()

data class WeatherDataModel(
    val temperature: String,
    val measureTime: String,
    val updateTime: String,
    val location: Location
) : Response()

data class ErrorDataModel(
    val errorMessage: String?
) : Response()
