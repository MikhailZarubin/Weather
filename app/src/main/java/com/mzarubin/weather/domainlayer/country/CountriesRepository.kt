package com.mzarubin.weather.domainlayer.country

import com.mzarubin.weather.domainlayer.datamodel.Response
import kotlinx.coroutines.flow.Flow

interface CountriesRepository {

    /**
    * Return flow which contains response with CountriesDataModel or ErrorDataModel
    */
    fun getCountries(): Flow<Response>
}
