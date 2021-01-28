package com.example.maps_weather

import android.R.attr.description
import android.R.attr.priority
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maps_weather.Dbase.Note
import kotlinx.android.synthetic.main.list_fragment.*


class History_fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycle_view.layoutManager = LinearLayoutManager(context)
        recycle_view.setHasFixedSize(true)
        val adapter = NoteAdapter()
        recycle_view.adapter = adapter

        var noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        noteViewModel.getAllNotes()
            ?.observe(this, object : Observer<List<Note?>?> {
                override fun onChanged(@Nullable notes: List<Note?>?) {
                    adapter.setNotes(notes as List<Note>);
                }
            })
    }
}