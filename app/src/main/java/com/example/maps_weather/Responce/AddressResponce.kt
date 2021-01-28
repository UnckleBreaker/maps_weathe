package com.example.maps_weather.Responce

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class AddressResponce {

    @SerializedName("plus_code")
    @Expose
    private var plusCode: PlusCode? = null

    @SerializedName("results")
    @Expose
    private var results: List<Result?>? = null

    @SerializedName("status")
    @Expose
    private var status: String? = null

    fun getPlusCode(): PlusCode? {
        return plusCode
    }

    fun setPlusCode(plusCode: PlusCode?) {
        this.plusCode = plusCode
    }

    fun withPlusCode(plusCode: PlusCode?): AddressResponce? {
        this.plusCode = plusCode
        return this
    }

    fun getResults(): List<Result?>? {
        return results
    }

    fun setResults(results: List<Result?>?) {
        this.results = results
    }

    fun withResults(results: List<Result?>?): AddressResponce? {
        this.results = results
        return this
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun withStatus(status: String?): AddressResponce? {
        this.status = status
        return this
    }
    class AddressComponent {
        @SerializedName("long_name")
        @Expose
        var longName: String? = null

        @SerializedName("short_name")
        @Expose
        var shortName: String? = null

        @SerializedName("types")
        @Expose
        var types: List<String>? = null

        fun withLongName(longName: String?): AddressComponent {
            this.longName = longName
            return this
        }

        fun withShortName(shortName: String?): AddressComponent {
            this.shortName = shortName
            return this
        }

        fun withTypes(types: List<String>?): AddressComponent {
            this.types = types
            return this
        }
    }
    class Geometry {
        @SerializedName("location")
        @Expose
        private var location: Location? = null

        @SerializedName("location_type")
        @Expose
        var locationType: String? = null

        @SerializedName("viewport")
        @Expose
        private var viewport: Viewport? = null

        @SerializedName("bounds")
        @Expose
        private var bounds: Bounds? = null
        fun getLocation(): Location? {
            return location
        }

        fun setLocation(location: Location?) {
            this.location = location
        }

        fun withLocation(location: Location?): Geometry {
            this.location = location
            return this
        }

        fun withLocationType(locationType: String?): Geometry {
            this.locationType = locationType
            return this
        }

        fun getViewport(): Viewport? {
            return viewport
        }

        fun setViewport(viewport: Viewport?) {
            this.viewport = viewport
        }

        fun withViewport(viewport: Viewport?): Geometry {
            this.viewport = viewport
            return this
        }

        fun getBounds(): Bounds? {
            return bounds
        }

        fun setBounds(bounds: Bounds?) {
            this.bounds = bounds
        }

        fun withBounds(bounds: Bounds?): Geometry {
            this.bounds = bounds
            return this
        }
    }
    class Location {
        @SerializedName("lat")
        @Expose
        var lat: Double? = null

        @SerializedName("lng")
        @Expose
        var lng: Double? = null

        fun withLat(lat: Double?): Location {
            this.lat = lat
            return this
        }

        fun withLng(lng: Double?): Location {
            this.lng = lng
            return this
        }
    }
    class Northeast {
        @SerializedName("lat")
        @Expose
        var lat: Double? = null

        @SerializedName("lng")
        @Expose
        var lng: Double? = null

        fun withLat(lat: Double?): Northeast {
            this.lat = lat
            return this
        }

        fun withLng(lng: Double?): Northeast {
            this.lng = lng
            return this
        }
    }
    class Northeast_ {
        @SerializedName("lat")
        @Expose
        var lat: Double? = null

        @SerializedName("lng")
        @Expose
        var lng: Double? = null

        fun withLat(lat: Double?): Northeast_ {
            this.lat = lat
            return this
        }

        fun withLng(lng: Double?): Northeast_ {
            this.lng = lng
            return this
        }
    }
    class PlusCode {
        @SerializedName("compound_code")
        @Expose
        var compoundCode: String? = null

        @SerializedName("global_code")
        @Expose
        var globalCode: String? = null

        fun withCompoundCode(compoundCode: String?): PlusCode {
            this.compoundCode = compoundCode
            return this
        }

        fun withGlobalCode(globalCode: String?): PlusCode {
            this.globalCode = globalCode
            return this
        }
    }
    class PlusCode_ {
        @SerializedName("compound_code")
        @Expose
        var compoundCode: String? = null

        @SerializedName("global_code")
        @Expose
        var globalCode: String? = null

        fun withCompoundCode(compoundCode: String?): PlusCode_ {
            this.compoundCode = compoundCode
            return this
        }

        fun withGlobalCode(globalCode: String?): PlusCode_ {
            this.globalCode = globalCode
            return this
        }
    }
    class Result {
        @SerializedName("address_components")
        @Expose
        var addressComponents: List<AddressComponent>? = null

        @SerializedName("formatted_address")
        @Expose
        var formattedAddress: String? = null

        @SerializedName("geometry")
        @Expose
        var geometry: Geometry? = null

        @SerializedName("place_id")
        @Expose
        var placeId: String? = null

        @SerializedName("plus_code")
        @Expose
        var plusCode: PlusCode_? = null

        @SerializedName("types")
        @Expose
        var types: List<String>? = null

        fun withAddressComponents(addressComponents: List<AddressComponent>?): Result {
            this.addressComponents = addressComponents
            return this
        }

        fun withFormattedAddress(formattedAddress: String?): Result {
            this.formattedAddress = formattedAddress
            return this
        }

        fun withGeometry(geometry: Geometry?): Result {
            this.geometry = geometry
            return this
        }

        fun withPlaceId(placeId: String?): Result {
            this.placeId = placeId
            return this
        }

        fun withPlusCode(plusCode: PlusCode_?): Result {
            this.plusCode = plusCode
            return this
        }

        fun withTypes(types: List<String>?): Result {
            this.types = types
            return this
        }
    }
    class Southwest {
        @SerializedName("lat")
        @Expose
        var lat: Double? = null

        @SerializedName("lng")
        @Expose
        var lng: Double? = null

        fun withLat(lat: Double?): Southwest {
            this.lat = lat
            return this
        }

        fun withLng(lng: Double?): Southwest {
            this.lng = lng
            return this
        }
    }
    class Southwest_ {
        @SerializedName("lat")
        @Expose
        var lat: Double? = null

        @SerializedName("lng")
        @Expose
        var lng: Double? = null

        fun withLat(lat: Double?): Southwest_ {
            this.lat = lat
            return this
        }

        fun withLng(lng: Double?): Southwest_ {
            this.lng = lng
            return this
        }
    }
    class Viewport {
        @SerializedName("northeast")
        @Expose
        var northeast: Northeast? = null

        @SerializedName("southwest")
        @Expose
        var southwest: Southwest? = null

        fun withNortheast(northeast: Northeast?): Viewport {
            this.northeast = northeast
            return this
        }

        fun withSouthwest(southwest: Southwest?): Viewport {
            this.southwest = southwest
            return this
        }
    }
    class Bounds {
        @SerializedName("northeast")
        @Expose
        var northeast: Northeast_? = null

        @SerializedName("southwest")
        @Expose
        var southwest: Southwest_? = null

        fun withNortheast(northeast: Northeast_?): Bounds {
            this.northeast = northeast
            return this
        }

        fun withSouthwest(southwest: Southwest_?): Bounds {
            this.southwest = southwest
            return this
        }
    }
}