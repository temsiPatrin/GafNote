package temsi.gafnote.ui.viewfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_view.*
import org.koin.android.ext.android.inject

import temsi.gafnote.R
import temsi.gafnote.domain.entities.Note
import temsi.gafnote.ui.FragmentCallback
import temsi.gafnote.ui.viewfragment.dialogfragment.DeleteDialog


class ViewFragment() : Fragment(),ContractViewFrag.View,DeleteDialog.DialogOnClickListener {
    private var note: Note? = null

    val presenter: ContractViewFrag.Presenter by inject()

    private var callback: FragmentCallback?= null
    private lateinit var  vTitle: TextView
    private lateinit var  vContent: TextView

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
        val view = inflater.inflate(R.layout.fragment_view, container, false)

        val bundle = arguments
        note = bundle?.getParcelable<Note>("selected") as Note

        vTitle = view.findViewById(R.id.vTitle)
        vContent = view.findViewById(R.id.vContent)

        presenter.attachView(this)
        presenter.prepareNote(note!!)

        return view
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.view_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.vDeleteItem ->{
                showDialog()
                true
            }
            R.id.vEditItem ->{
                val args = Bundle()
                args.putParcelable("selectedEdit",note)
                callback?.loadEditFragmentWithNote(args)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun showDialog(){
        val dialog = DeleteDialog()
        dialog.setTargetFragment(this,1)
        dialog.show(parentFragmentManager,"MyDialog")
    }

    override fun showNote(title: String, content: String) {
        vTitle.text = title
        vContent.text = content
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }

    override fun onDialogPositiveClickListener() {
        presenter.delete(note!!)
        callback?.loadMainFragment()
    }


}