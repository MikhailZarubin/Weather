package com.mzarubin.weather.datalayer.di

import com.mzarubin.weather.datalayer.cache.CountriesRuntimeCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun provideCountriesRuntimeCache(): CountriesRuntimeCache {
        return CountriesRuntimeCache()
    }
}
