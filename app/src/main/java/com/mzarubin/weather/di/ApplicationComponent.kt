package com.mzarubin.weather.di

import android.app.Application
import com.mzarubin.weather.datalayer.cache.di.CacheModule
import com.mzarubin.weather.datalayer.database.di.DataBaseModule
import com.mzarubin.weather.datalayer.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CacheModule::class,
        DataBaseModule::class,
        NetworkModule::class]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}
