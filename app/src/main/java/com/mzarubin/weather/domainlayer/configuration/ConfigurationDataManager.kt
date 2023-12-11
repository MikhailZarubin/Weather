package com.mzarubin.weather.domainlayer.configuration

interface ConfigurationDataManager {

    suspend fun setUseCurrentCoordinates(isUseCurrentCoordinates: Boolean)
}
