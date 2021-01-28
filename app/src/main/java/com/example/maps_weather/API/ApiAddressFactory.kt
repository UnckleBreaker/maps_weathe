package com.example.maps_weather.API

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiAddressFactory {
    private var SokHttpClient: OkHttpClient? = null
    private var SapiAdress: ApiWeather? = null
    val adressApi: ApiWeather?
        get() {
            var apiAdress = SapiAdress
            if (apiAdress == null) {
                synchronized(ApiWeather::class.java) {
                    apiAdress = SapiAdress
                    if (apiAdress == null) {
                        SapiAdress = createService()
                        apiAdress = SapiAdress
                    }
                }
            }
            return apiAdress
        }

    private fun createService(): ApiWeather {
        return Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/maps/api/geocode/")
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
                synchronized(ApiAddressFactory::class.java) {
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
            .addInterceptor(ApiKeyAdressInterceptor())
            .build()
    }
}