package com.example.maps_weather.Responce


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class WeatherResponce  {
    @SerializedName("coord")
    @Expose
    val coord: Coord? = null

    @SerializedName("weather")
    @Expose
    val weather: List<Weather>? = null

    @SerializedName("base")
    @Expose
    val base: String? = null

    @SerializedName("main")
    @Expose
    val main: Main? = null

    @SerializedName("visibility")
    @Expose
    val visibility = 0

    @SerializedName("wind")
    @Expose
    val wind: Wind? = null

    @SerializedName("clouds")
    @Expose
    val clouds: Clouds? = null

    @SerializedName("dt")
    @Expose
    val dt = 0

    @SerializedName("sys")
    @Expose
    val sys: Sys? = null

    @SerializedName("id")
    @Expose
    val id = 0

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("cod")
    @Expose
    val cod = 0

    inner class Wind {
        @SerializedName("speed")
        @Expose
        var speed = 0f

        @SerializedName("deg")
        @Expose
        var deg = 0

    }

    inner class Weather {
        @SerializedName("id")
        @Expose
        var id = 0

        @SerializedName("main")
        @Expose
        var main: String? = null

        @SerializedName("description")
        @Expose
        var description: String? = null

        @SerializedName("icon")
        @Expose
        var icon: String? = null

    }

    inner class Sys {
        @SerializedName("type")
        @Expose
        var type = 0

        @SerializedName("id")
        @Expose
        var id = 0

        @SerializedName("message")
        @Expose
        var message = 0f

        @SerializedName("country")
        @Expose
        var country: String? = null

        @SerializedName("sunrise")
        @Expose
        var sunrise = 0

        @SerializedName("sunset")
        @Expose
        var sunset = 0

    }

    inner class Main {
        @SerializedName("temp")
        @Expose
        var temp = 0f

        @SerializedName("pressure")
        @Expose
        var pressure = 0

        @SerializedName("humidity")
        @Expose
        var humidity = 0

        @SerializedName("temp_min")
        @Expose
        var tempMin = 0f

        @SerializedName("temp_max")
        @Expose
        var tempMax = 0f

    }

    inner class Coord {
        @SerializedName("lon")
        @Expose
        var lon = 0f

        @SerializedName("lat")
        @Expose
        var lat = 0f

    }

    inner class Clouds {
        @SerializedName("all")
        @Expose
        var all = 0

    }
}