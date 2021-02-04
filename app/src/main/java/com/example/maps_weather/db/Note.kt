package com.example.maps_weather.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
class Note(val time: String, val location: String, val adress: String) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}