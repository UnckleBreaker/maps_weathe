package com.example.maps_weather.API

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ApiKeyAdressInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("key", "AIzaSyB9SZm874KoFdcvS4PVLAe1HU8MHGmcqRc")
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}