package com.mzarubin.weather.datalayer.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor(
    var queryParamsMap: Map<String, String> = emptyMap()
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifyRequest = originalRequest.newBuilder()
            .url(applyQueryParams(originalRequest.url))
            .build()
        return chain.proceed(modifyRequest)
    }

    private fun applyQueryParams(originalUrl: HttpUrl): HttpUrl {
        val urlBuilder = originalUrl.newBuilder()
        queryParamsMap.forEach { (key, param) ->
            urlBuilder.addQueryParameter(key, param)
        }
        return urlBuilder.build()
    }
}
