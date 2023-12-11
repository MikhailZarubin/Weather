package com.mzarubin.weather.domainlayer.location

import com.mzarubin.weather.domainlayer.datamodel.LocalityDataModel

interface LocationDataManager {

    suspend fun addFavoriteLocality(localityDataModel: LocalityDataModel)

    suspend fun deleteFavoriteLocality(localityDataModel: LocalityDataModel)
}
