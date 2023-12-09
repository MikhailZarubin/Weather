package com.mzarubin.weather.datalayer.network.di

import com.mzarubin.weather.BuildConfig
import com.mzarubin.weather.datalayer.network.CountriesService
import com.mzarubin.weather.datalayer.network.RequestInterceptor
import com.mzarubin.weather.datalayer.network.WeatherService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
    }

    @Provides
    @Singleton
    fun provideCountriesService(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): CountriesService {
        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.COUNTRIES_SERVER_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRequestInterceptor(): RequestInterceptor {
        return RequestInterceptor()
    }

    @Provides
    @Singleton
    fun provideWeatherService(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        requestInterceptor: RequestInterceptor
    ): WeatherService {
        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(requestInterceptor.apply {
                queryParamsMap = mapOf("key" to BuildConfig.WEATHER_API_KEY)
            })
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.WEATHER_SERVER_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }
}
