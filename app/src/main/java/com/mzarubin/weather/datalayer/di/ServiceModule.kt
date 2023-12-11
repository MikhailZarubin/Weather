package com.mzarubin.weather.datalayer.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.mzarubin.weather.datalayer.service.ConfigurationService
import com.mzarubin.weather.datalayer.service.ConfigurationServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideSharedPreference(application: Application): SharedPreferences {
        return application.getSharedPreferences("weather_shared_pref", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideConfigurationService(sharedPreferences: SharedPreferences): ConfigurationService {
        return ConfigurationServiceImpl(sharedPreferences)
    }
}
