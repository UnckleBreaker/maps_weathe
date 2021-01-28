package com.example.maps_weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.maps_weather.Dbase.Note
import kotlinx.android.synthetic.main.item.view.*


class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    private var notes: List<Note> = ArrayList()

    @NonNull
    override fun onCreateViewHolder(
        @NonNull parent: ViewGroup,
        viewType: Int
    ): NoteHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return NoteHolder(itemView)
    }

    override fun onBindViewHolder(
        @NonNull holder: NoteHolder,
        position: Int
    ) {
        val currentNote: Note = notes[position]
        holder.itemView.time.setText(currentNote.time)
        holder.itemView.adres.setText(currentNote.adress)
        holder.itemView.locatio.setText(currentNote.location)

    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

     inner class NoteHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val time: TextView
        private val adress: TextView
        private val location: TextView

        init {
            time = itemView.findViewById(R.id.time)
            adress = itemView.findViewById(R.id.adres)
            location = itemView.findViewById(R.id.locatio)
        }
    }
}