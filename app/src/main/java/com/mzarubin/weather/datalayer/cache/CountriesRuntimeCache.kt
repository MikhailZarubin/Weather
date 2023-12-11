package com.mzarubin.weather.datalayer.cache

import com.mzarubin.weather.datalayer.datamodel.CountryServerModel
import okhttp3.internal.toImmutableList

class CountriesRuntimeCache : RuntimeCache<List<CountryServerModel>> {

    override fun addToCache(data: List<CountryServerModel>) {
        COUNTRIES_LIST.addAll(data)
    }

    override fun getCache(): List<CountryServerModel> {
        return COUNTRIES_LIST.toImmutableList()
    }

    override fun hasCache(): Boolean {
        return COUNTRIES_LIST.isNotEmpty()
    }

    override fun clearCache() {
        COUNTRIES_LIST.clear()
    }

    /**
     * To store cached data in a separate memory region (Metaspace) need to use a static initialization area
     */
    private companion object {
        val COUNTRIES_LIST: MutableList<CountryServerModel> = ArrayList()
    }
}
