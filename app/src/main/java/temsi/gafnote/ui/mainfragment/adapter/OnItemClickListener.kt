package temsi.gafnote.ui.mainfragment.adapter

import temsi.gafnote.domain.entities.Note

interface OnItemClickListener {
    fun onItemClick(note: Note)
}