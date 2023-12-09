package com.mzarubin.weather.datalayer.cache

interface RuntimeCache<T> {

    fun addToCache(data: T)

    fun getCache(): T

    fun clearCache()
}
