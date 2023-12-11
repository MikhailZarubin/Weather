package com.mzarubin.weather.domainlayer.country

import com.mzarubin.weather.datalayer.cache.CountriesRuntimeCache
import com.mzarubin.weather.datalayer.datamodel.CountriesResponse
import com.mzarubin.weather.datalayer.datamodel.CountryServerModel
import com.mzarubin.weather.datalayer.network.CountriesService
import com.mzarubin.weather.domainlayer.datamodel.CountriesDataModel
import com.mzarubin.weather.domainlayer.datamodel.CountryDataModel
import com.mzarubin.weather.domainlayer.datamodel.ErrorDataModel
import com.mzarubin.weather.domainlayer.datamodel.LocalitiesDataModel
import com.mzarubin.weather.domainlayer.datamodel.LocalityDataModel
import com.mzarubin.weather.domainlayer.datamodel.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val countriesService: CountriesService,
    private val countriesRuntimeCache: CountriesRuntimeCache
) : CountriesRepository {

    override fun getCountries(): Flow<Response> {
        return flow {
            if (countriesRuntimeCache.hasCache()) {
                emit(adoptToCountriesDataModel(countriesRuntimeCache.getCache()))
            } else {
                executeServerResponse(countriesService.fetchAllCountries())
            }
        }.onEach { Timber.d("Countries updated $it") }
    }

    private suspend fun FlowCollector<Response>.executeServerResponse(countriesResponse: CountriesResponse) {
        if (countriesResponse.error) {
            emit(ErrorDataModel(countriesResponse.message))
        } else {
            countriesRuntimeCache.addToCache(countriesResponse.countriesData)
            emit(adoptToCountriesDataModel(countriesResponse.countriesData))
        }
    }

    private fun adoptToCountriesDataModel(countries: List<CountryServerModel>): CountriesDataModel {
        return CountriesDataModel(countries.map { adoptToCountryDataModel(it) }.toList())
    }

    private fun adoptToCountryDataModel(country: CountryServerModel): CountryDataModel {
        return CountryDataModel(country.countryName, adoptToLocalities(country))
    }

    private fun adoptToLocalities(country: CountryServerModel): LocalitiesDataModel {
        return LocalitiesDataModel(
            country.citiesNameList.map { LocalityDataModel(country.countryName, it) }.toList()
        )
    }
}
