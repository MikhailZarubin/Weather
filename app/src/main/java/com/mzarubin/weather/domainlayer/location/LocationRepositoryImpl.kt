package com.mzarubin.weather.domainlayer.location

import com.mzarubin.weather.datalayer.database.FavoriteLocalitiesSourceDao
import com.mzarubin.weather.datalayer.datamodel.LocalityEntity
import com.mzarubin.weather.domainlayer.datamodel.LocalitiesDataModel
import com.mzarubin.weather.domainlayer.datamodel.LocalityDataModel
import com.mzarubin.weather.domainlayer.datamodel.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val favoriteLocalitiesSourceDao: FavoriteLocalitiesSourceDao
) : LocationRepository {

    override fun getFavoriteLocalities(): Flow<Response> {
        return flow {
            emit(adoptToLocalitiesDataModel(favoriteLocalitiesSourceDao.getFavoriteLocalities()))
        }
    }

    override fun getCurrentCoordinates(): Flow<Response> {
        TODO("Not yet implemented")
    }

    private fun adoptToLocalitiesDataModel(favoriteLocalities: List<LocalityEntity>): LocalitiesDataModel {
        return LocalitiesDataModel(favoriteLocalities.map { adoptToLocalityDataModel(it) }.toList())
    }

    private fun adoptToLocalityDataModel(localityEntity: LocalityEntity): LocalityDataModel {
        return LocalityDataModel(localityEntity.countryName, localityEntity.localityName)
    }
}
