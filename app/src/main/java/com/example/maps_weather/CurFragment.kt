package com.example.maps_weather

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.maps_weather.API.ApiAddressFactory
import com.example.maps_weather.API.ApiFactory
import com.example.maps_weather.API.ApiWeather
import com.example.maps_weather.Dbase.Note
import com.example.maps_weather.Responce.AddressResponce
import com.example.maps_weather.Responce.WeatherResponce
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.current.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CurFragment : Fragment() {
    var cont: Context? = null
    lateinit var loca: Location
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cont = container?.context!!
        return inflater.inflate(R.layout.current, container, false)
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loca = LocationService(cont).getLocation()!!
        var noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        val dateTime = LocalDateTime.now()
        var str =
            "Latitude is ${loca?.latitude.toString()} longitude is ${loca?.longitude.toString()} "
        location.setText(str)
        getWeather()?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe { wea->
                if (wea != null) {
                    weather.setText("${wea.main?.temp?.minus(273)?.toInt()} C")
                }
            }
        getAddress()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe{ addr->
                if (addr != null) {
                    var ad =addr.getResults()?.get(0)?.formattedAddress
                    val note = Note(dateTime.format(DateTimeFormatter.ofPattern("M/d/y H:m:ss")), "${location.text}", "${ad}")
                    noteViewModel.insert(note)
                    adress.setText("$ad")
                }
            }


    }

    fun getWeather(): Observable<WeatherResponce?>? {
        return ApiFactory
            .weatherApi
            ?.getWeather(loca.latitude.toString(),loca.longitude.toString())


    }
    fun getAddress():Observable<AddressResponce?>?{
        return ApiAddressFactory
            .adressApi
            ?.getAddress("${loca.latitude},${loca.longitude}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

}


