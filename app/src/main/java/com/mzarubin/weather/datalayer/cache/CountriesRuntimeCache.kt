package com.mzarubin.weather.datalayer.cache

import com.mzarubin.weather.datamodel.CountryDataModel
import okhttp3.internal.toImmutableList

class CountriesRuntimeCache : RuntimeCache<List<CountryDataModel>> {

    override fun addToCache(data: List<CountryDataModel>) {
        COUNTRIES_LIST.addAll(data)
    }

    override fun getCache(): List<CountryDataModel> {
        return COUNTRIES_LIST.toImmutableList()
    }

    override fun clearCache() {
        COUNTRIES_LIST.clear()
    }

    /**
     * To store cached data in a separate memory region (Metaspace) need to use a static initialization area
     */
    private companion object {
        val COUNTRIES_LIST: MutableList<CountryDataModel> = ArrayList()
    }
}
