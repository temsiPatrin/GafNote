package temsi.gafnote.ui.editfragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import org.koin.android.ext.android.inject
import temsi.gafnote.R
import temsi.gafnote.domain.entities.Note
import temsi.gafnote.presenters.MVPContract
import temsi.gafnote.ui.FragmentCallback


class EditFragment : Fragment(),ContractEditFrag.View {

    val presenter: ContractEditFrag.Presenter by inject()
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
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_note, container, false)

        val editTitle: EditText = view.findViewById(R.id.editTitle)
        val editContent: EditText = view.findViewById(R.id.editContent)
        val saveNote: ImageView = view.findViewById(R.id.save_note)

        saveNote.setOnClickListener {
            val note = Note(
                null,
                editTitle.text.toString(),
                editContent.text.toString()
            )
            presenter.insert(note)
            callback?.loadMainFragment()
        }


        return view
    }
    fun abc() {

    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }


}