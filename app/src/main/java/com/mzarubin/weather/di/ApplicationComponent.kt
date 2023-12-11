package com.mzarubin.weather.di

import android.app.Application
import com.mzarubin.weather.datalayer.di.CacheModule
import com.mzarubin.weather.datalayer.di.DataBaseModule
import com.mzarubin.weather.datalayer.di.NetworkModule
import com.mzarubin.weather.datalayer.di.ServiceModule
import com.mzarubin.weather.model.di.CommonModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CacheModule::class,
        CommonModelModule::class,
        DataBaseModule::class,
        NetworkModule::class,
        ServiceModule::class]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}
