package com.mzarubin.weather.domainlayer.configuration

import com.mzarubin.weather.datalayer.service.ConfigurationService
import javax.inject.Inject

class ConfigurationDataManagerImpl @Inject constructor(
    private val configurationService: ConfigurationService
) : ConfigurationDataManager {

    override suspend fun setUseCurrentCoordinates(isUseCurrentCoordinates: Boolean) {
        configurationService.setUseCurrentCoordinatesProperty(isUseCurrentCoordinates)
    }
}
