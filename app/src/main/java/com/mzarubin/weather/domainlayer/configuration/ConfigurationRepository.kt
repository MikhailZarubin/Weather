package com.mzarubin.weather.domainlayer.configuration

import com.mzarubin.weather.domainlayer.datamodel.Response
import kotlinx.coroutines.flow.Flow

interface ConfigurationRepository {

    /**
     * Return flow which contains response with ConfigurationDataModel
     */
    fun getConfiguration(): Flow<Response>
}
