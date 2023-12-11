package com.mzarubin.weather.domainlayer.location

import com.mzarubin.weather.domainlayer.datamodel.Response
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    /**
     * Return flow which contains response with LocalitiesDataModel
     */
    fun getFavoriteLocalities(): Flow<Response>

    //: TODO
    fun getCurrentCoordinates(): Flow<Response>
}
