package com.example.maps_weather.API

import com.example.maps_weather.Responce.AddressResponce
import com.example.maps_weather.Responce.WeatherResponce
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWeather {
    @GET("weather?")
    fun getWeather(@Query("lat") lat: String?,@Query("lon") lon :String): Observable<WeatherResponce?>?

    @GET("json?")
    fun getAddress(@Query("latlng") lat: String?): Observable<AddressResponce?>?
}