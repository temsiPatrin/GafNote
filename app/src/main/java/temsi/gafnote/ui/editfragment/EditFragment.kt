package temsi.gafnote.ui.editfragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.koin.android.ext.android.inject
import temsi.gafnote.R
import temsi.gafnote.domain.entities.Note
import temsi.gafnote.ui.FragmentCallback


class EditFragment : Fragment(),ContractEditFrag.View {

    val presenter: ContractEditFrag.Presenter by inject()
    private var callback: FragmentCallback? =null
    private var note: Note? = null
    private lateinit var  editTitle: TextView
    private lateinit var  editContent: TextView

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
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_edit, container, false)

        editTitle = view.findViewById(R.id.editTitle)
        editContent = view.findViewById(R.id.editContent)
        val editNote: ImageView = view.findViewById(R.id.edit_note)

        val bundle = arguments
        note = bundle?.getParcelable<Note>("selectedEdit") as Note

        presenter.attachView(this)
        presenter.prepareNote(note!!)

        editNote.setOnClickListener{
            note!!.title = editTitle.text.toString()
            note!!.content = editContent.text.toString()
            presenter.update(note!!)
            callback?.loadMainFragment()
        }

        return view
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }

    override fun showNote(title: String, content: String) {
        editTitle.text = title
        editContent.text = content
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }


}