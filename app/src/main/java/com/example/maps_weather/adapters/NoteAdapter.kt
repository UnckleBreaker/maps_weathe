package com.example.maps_weather.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.maps_weather.db.Note
import com.example.maps_weather.R
import kotlinx.android.synthetic.main.item.view.*


class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    private var notes: List<Note> = ArrayList()
    lateinit var listner: OnItemClickListener

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

        holder.itemView.setOnClickListener (object :View.OnClickListener{
            override fun onClick(v: View?) {
                val position=  holder.adapterPosition
                if(listner!= null && position!= RecyclerView.NO_POSITION){
                    listner.onItemClick(notes.get(position))
                }
            }
        })

    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }
    fun getNoteAt(position: Int) =notes.get(position)

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
    interface OnItemClickListener {
        fun onItemClick(note: Note?)
    }
    fun setOnItemClickListener(Listner: OnItemClickListener){
        listner=Listner
    }

}