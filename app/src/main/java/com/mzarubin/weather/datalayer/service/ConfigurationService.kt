package com.mzarubin.weather.datalayer.service

/**
 * Used to connect to the Local SharedPreference and working with Configuration properties
 */
interface ConfigurationService {

    fun getUseCurrentCoordinatesProperty(): Boolean

    fun setUseCurrentCoordinatesProperty(useCurrentCoordinates: Boolean)
}
