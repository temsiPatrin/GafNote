package temsi.gafnote.ui.mainfragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import temsi.gafnote.R
import temsi.gafnote.domain.entities.Note

import temsi.gafnote.presenters.MVPContract
import temsi.gafnote.ui.FragmentCallback
import temsi.gafnote.ui.mainfragment.adapter.NotesRecyclerViewAdapter
import temsi.gafnote.ui.mainfragment.adapter.OnItemClickListener


class MainFragment : Fragment(), ContractMainFrag.View,OnItemClickListener {
    val presenter: ContractMainFrag.Presenter by inject()
    private var callback: FragmentCallback? =null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity is FragmentCallback) {
            this.callback = activity as FragmentCallback
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_list, container, false)

        val addNote: ImageView = view.findViewById(R.id.add_note)


        addNote.setOnClickListener { callback?.loadEditFragment() }

        // Set the adapter
        val recyclerView: RecyclerView = view.findViewById(R.id.list)

        recyclerView.layoutManager = LinearLayoutManager(context)
        presenter.getAllNotes().observe(viewLifecycleOwner, Observer<List<Note>> { notes ->
            recyclerView.adapter =
                NotesRecyclerViewAdapter(notes,this)
        })

        return view
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }

    override fun onItemClick(note: Note) {
        callback?.onItemClick()
    }

}