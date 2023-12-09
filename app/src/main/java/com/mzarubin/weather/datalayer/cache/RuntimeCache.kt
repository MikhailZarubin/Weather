package com.mzarubin.weather.datalayer.cache

/**
 * Used to save data in Runtime for quickly access on it
 */
interface RuntimeCache<T> {

    fun addToCache(data: T)

    fun getCache(): T

    fun clearCache()
}
