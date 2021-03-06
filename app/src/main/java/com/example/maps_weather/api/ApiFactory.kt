package com.example.maps_weather.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    private var SokHttpClient: OkHttpClient? = null
    private var SapiWeather: ApiWeather? = null
    val weatherApi: ApiWeather?
        get() {
            var apiWeather = SapiWeather
            if (apiWeather == null) {
                synchronized(ApiWeather::class.java) {
                    apiWeather = SapiWeather
                    if (apiWeather == null) {
                        SapiWeather = createService()
                        apiWeather = SapiWeather
                    }
                }
            }
            return apiWeather
        }

    private fun createService(): ApiWeather {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiWeather::class.java)
    }

    private val client: OkHttpClient?
        private get() {
            var okHttpClient = SokHttpClient
            if (okHttpClient == null) {
                synchronized(ApiFactory::class.java) {
                    okHttpClient = SokHttpClient
                    if (okHttpClient == null) {
                        SokHttpClient = buildClient()
                        okHttpClient = SokHttpClient
                    }
                }
            }
            return okHttpClient
        }

    private fun buildClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(ApiKeyInterceptor())
            .build()
    }
}