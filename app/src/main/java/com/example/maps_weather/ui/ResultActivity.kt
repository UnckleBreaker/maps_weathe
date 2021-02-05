package com.example.maps_weather.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.maps_weather.R
import kotlinx.android.synthetic.main.show_activity.*

class ResultActivity() : AppCompatActivity() {
    val id = "com.example.maps_weather.id"
    val time = "com.example.maps_weather.time"
    val adress = "com.example.maps_weather.adress"
    val location = "com.example.maps_weather.location"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_activity)
        var intent = getIntent();
        if (intent.hasExtra(id)) {

            time_t.setText("${time_t.text} ${intent.getStringExtra(time)}")
            adress_t.setText("${adress_t.text} ${intent.getStringExtra(adress)}")
            locatio_t.setText("${locatio_t.text} ${intent.getStringExtra(location)}")
            setTitle("Information")
        }
    }
}