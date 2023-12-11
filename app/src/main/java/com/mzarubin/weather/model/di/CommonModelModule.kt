package com.mzarubin.weather.model.di

import com.mzarubin.weather.model.EventInterceptor
import com.mzarubin.weather.model.EventInterceptorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CommonModelModule {

    @Provides
    @Singleton
    fun provideEventInterceptor(): EventInterceptor {
        return EventInterceptorImpl()
    }
}
