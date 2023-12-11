package com.mzarubin.weather.domainlayer.weather

import com.mzarubin.weather.datalayer.database.WeatherLocalitiesSourceDao
import com.mzarubin.weather.datalayer.datamodel.LocationServerModel
import com.mzarubin.weather.datalayer.datamodel.WeatherEntity
import com.mzarubin.weather.datalayer.datamodel.WeatherResponse
import com.mzarubin.weather.datalayer.datamodel.WeatherServerModel
import com.mzarubin.weather.datalayer.network.WeatherService
import com.mzarubin.weather.domainlayer.datamodel.ErrorDataModel
import com.mzarubin.weather.domainlayer.datamodel.Location
import com.mzarubin.weather.domainlayer.datamodel.Response
import com.mzarubin.weather.domainlayer.datamodel.WeatherDataModel
import com.mzarubin.weather.util.getId
import com.mzarubin.weather.util.getName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherService: WeatherService,
    private val weatherLocalitiesSourceDao: WeatherLocalitiesSourceDao
) : WeatherRepository {

    override fun getWeather(location: Location): Flow<Response> {
        return flow {
            emit(
                adoptToWeatherDataModel(
                    location,
                    weatherLocalitiesSourceDao.getWeatherByLocalityId(
                        location.getId()
                    )
                )
            )
            executeServerResponse(
                location,
                weatherService.fetchWeatherByLocality(location.getName())
            )
        }.onEach { Timber.d("Weather updated $it") }
    }

    private suspend fun FlowCollector<Response>.executeServerResponse(
        location: Location,
        weatherResponse: WeatherResponse
    ) {
        if (weatherResponse.error != null) {
            emit(ErrorDataModel(weatherResponse.error.errorMessage))
        } else if (weatherResponse.weatherData != null && weatherResponse.locationData != null) {
            emit(
                adoptToWeatherDataModel(
                    location,
                    weatherResponse.locationData,
                    weatherResponse.weatherData
                )
            )
        } else {
            Timber.e("Invalid response by fetchWeatherByLocality()")
        }
    }

    private fun adoptToWeatherDataModel(
        location: Location,
        weatherEntity: WeatherEntity
    ): WeatherDataModel {
        return WeatherDataModel(
            weatherEntity.temperature,
            weatherEntity.measureTime,
            weatherEntity.updateTime,
            location
        )
    }

    private fun adoptToWeatherDataModel(
        location: Location,
        localityServerModel: LocationServerModel,
        weatherServerModel: WeatherServerModel
    ): WeatherDataModel {
        return WeatherDataModel(
            weatherServerModel.temperature,
            weatherServerModel.measureTime,
            localityServerModel.currentTime,
            location
        )
    }
}
