package com.example.maps_weather.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {
    @Insert
    fun insert(note: Note?)

    @Update
    fun update(note: Note?)

    @Delete
    fun delete(note: Note?)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @get:Query("SELECT * FROM note_table")
    val allNotes: LiveData<List<Note?>?>?
}