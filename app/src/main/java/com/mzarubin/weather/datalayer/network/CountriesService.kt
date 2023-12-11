package com.mzarubin.weather.datalayer.network

import com.mzarubin.weather.datalayer.datamodel.CountriesResponse
import retrofit2.http.GET

/**
 * Used to connect to the Countries API to fetch countries
 */
interface CountriesService {

    @GET("countries")
    suspend fun fetchAllCountries(): CountriesResponse
}
