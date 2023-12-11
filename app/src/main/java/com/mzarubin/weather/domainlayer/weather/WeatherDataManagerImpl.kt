package com.mzarubin.weather.domainlayer.weather

import com.mzarubin.weather.datalayer.database.WeatherLocalitiesAcceptorDao
import com.mzarubin.weather.datalayer.datamodel.WeatherEntity
import com.mzarubin.weather.domainlayer.datamodel.WeatherDataModel
import com.mzarubin.weather.util.getId
import javax.inject.Inject

class WeatherDataManagerImpl @Inject constructor(
    private val weatherLocalitiesAcceptorDao: WeatherLocalitiesAcceptorDao
) : WeatherDataManager {

    override suspend fun addWeatherLocality(weatherDataModel: WeatherDataModel) {
        weatherLocalitiesAcceptorDao.insertWeatherLocality(adoptToWeatherEntity(weatherDataModel))
    }

    override suspend fun deleteWeatherLocality(weatherDataModel: WeatherDataModel) {
        weatherLocalitiesAcceptorDao.deleteWeatherLocality(adoptToWeatherEntity(weatherDataModel))
    }

    private fun adoptToWeatherEntity(weatherDataModel: WeatherDataModel): WeatherEntity {
        return WeatherEntity(
            weatherDataModel.location.getId(),
            weatherDataModel.temperature,
            weatherDataModel.measureTime,
            weatherDataModel.updateTime
        )
    }
}
