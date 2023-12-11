package com.mzarubin.weather.domainlayer.location

import com.mzarubin.weather.datalayer.database.FavoriteLocalitiesAcceptorDao
import com.mzarubin.weather.datalayer.datamodel.LocalityEntity
import com.mzarubin.weather.domainlayer.datamodel.LocalityDataModel
import javax.inject.Inject

class LocationDataManagerImpl @Inject constructor(
    private val favoriteLocalitiesAcceptorDao: FavoriteLocalitiesAcceptorDao
) : LocationDataManager {

    override suspend fun addFavoriteLocality(localityDataModel: LocalityDataModel) {
        favoriteLocalitiesAcceptorDao.insertFavoriteLocality(adoptToLocalityEntity(localityDataModel))
    }

    override suspend fun deleteFavoriteLocality(localityDataModel: LocalityDataModel) {
        favoriteLocalitiesAcceptorDao.deleteFavoriteLocality(adoptToLocalityEntity(localityDataModel))
    }

    private fun adoptToLocalityEntity(localityDataModel: LocalityDataModel): LocalityEntity {
        return LocalityEntity(
            localityDataModel.hashCode(),
            localityDataModel.countryName,
            localityDataModel.localityName
        )
    }
}
