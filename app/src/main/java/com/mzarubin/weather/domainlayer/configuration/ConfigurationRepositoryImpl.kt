package com.mzarubin.weather.domainlayer.configuration

import com.mzarubin.weather.datalayer.service.ConfigurationService
import com.mzarubin.weather.domainlayer.datamodel.ConfigurationDataModel
import com.mzarubin.weather.domainlayer.datamodel.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ConfigurationRepositoryImpl @Inject constructor(
    private val configurationService: ConfigurationService
) : ConfigurationRepository {

    override fun getConfiguration(): Flow<Response> {
        return flow {
            emit(
                ConfigurationDataModel(
                    configurationService.getUseCurrentCoordinatesProperty()
                )
            )
        }
    }
}
