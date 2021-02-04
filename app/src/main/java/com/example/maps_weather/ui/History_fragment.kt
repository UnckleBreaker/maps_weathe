package com.example.maps_weather.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maps_weather.db.Note
import com.example.maps_weather.adapters.NoteAdapter
import com.example.maps_weather.R
import kotlinx.android.synthetic.main.list_fragment.*


class History_fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dividerItemDecorator =DividerItemDecoration(context,RecyclerView.VERTICAL)
        dividerItemDecorator.setDrawable(resources.getDrawable(R.drawable.divider_drawable))
        recycle_view.addItemDecoration(dividerItemDecorator)
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
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                noteViewModel.delete(adapter.getNoteAt(viewHolder.adapterPosition))
            }
        }).attachToRecyclerView(recycle_view)
        adapter.setOnItemClickListener(object :
            NoteAdapter.OnItemClickListener {
            override fun onItemClick(note: Note?) {
                activity?.let{

                    val intent = Intent (it, ResultActivity::class.java)
                    intent.putExtra(ResultActivity().id, note?.id);
                    intent.putExtra(ResultActivity().time, note?.time);
                    intent.putExtra(ResultActivity().adress, note?.adress);
                    intent.putExtra(ResultActivity().location, note?.location);
                    it.startActivity(intent)
                }
            }
        })


    }

}