package temsi.gafnote.ui.mainfragment.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import temsi.gafnote.R
import temsi.gafnote.domain.entities.Note



class NotesRecyclerViewAdapter(
    private val notes: List<Note>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<NotesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = notes[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = notes.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleView: TextView = view.findViewById(R.id.titleText)
        private val contentView: TextView = view.findViewById(R.id.contentText)
        init {
            view.setOnClickListener { onItemClickListener.onItemClick(notes[adapterPosition]) }
        }

        fun bind(note: Note) {
            titleView.text = note.title
            contentView.text = note.content
        }

    }
}