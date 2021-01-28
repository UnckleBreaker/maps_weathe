package com.example.maps_weather

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class LocationService(var context: Context?) : AppCompatActivity() {
    lateinit var locationManager: LocationManager
    private var hasGps = false
    private var hasNetwork = false
    private var locationGps: Location? = null
    private var locationNetwork: Location? = null
    var resultLocatoin: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Toast.makeText(this, "Your version is lower than M", Toast.LENGTH_LONG).show()
        }
    }

    fun getLocation(): Location? {
        locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if (hasGps || hasNetwork) {
            if (hasGps) {
                if (ActivityCompat.checkSelfPermission(context!!, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context!!, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        5000,
                        0F,
                        object : LocationListener {
                            override fun onLocationChanged(location: Location?) {
                                if (location != null)
                                    locationGps = location

                            }

                            override fun onStatusChanged(
                                provider: String?,
                                status: Int,
                                extras: Bundle?
                            ) {
                                TODO("Not yet implemented")
                            }

                            override fun onProviderEnabled(provider: String?) {
                                TODO("Not yet implemented")
                            }

                            override fun onProviderDisabled(provider: String?) {
                                TODO("Not yet implemented")
                            }

                        })
                }
            }
            if (hasNetwork) {
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    5000,
                    0F,
                    object : LocationListener {
                        override fun onLocationChanged(location: Location?) {
                            if (location != null) {
                                locationNetwork = location
                            }
                        }

                        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

                        }

                        override fun onProviderEnabled(provider: String?) {

                        }

                        override fun onProviderDisabled(provider: String?) {

                        }

                    })

                val localNetworkLocation =
                    locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                if (localNetworkLocation != null)
                    locationNetwork = localNetworkLocation
            }



        }

        if (locationGps != null ) {
            resultLocatoin = locationGps
        }
        if( locationNetwork != null)
        resultLocatoin = locationNetwork

        return resultLocatoin
    }

}