package com.mzarubin.weather.domainlayer.location

import com.mzarubin.weather.domainlayer.datamodel.Response
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    /**
     * Return flow which contains response with LocalitiesDataModel or ErrorDataModel
     */
    fun getFavoriteLocalities(): Flow<Response>

    /**
     * Return flow which contains response with CoordinatesDataModel or ErrorDataModel
     */
    fun getCurrentCoordinates(): Flow<Response>
}
