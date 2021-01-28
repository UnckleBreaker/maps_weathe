package com.example.maps_weather.API

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ApiKeyInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("appid", "8a29b63838cdbd86502c804767d21b4e")
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}