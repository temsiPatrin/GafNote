package temsi.gafnote.ui.viewfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_view.*
import org.koin.android.ext.android.inject
import temsi.gafnote.R


class ViewFragment : Fragment(),ContractViewFrag.View {

    val presenter: PresenterViewFrag by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view, container, false)


        return view
    }

    override fun showNote(title: String, content: String) {
        vTitle.text = title
        vContent.text = content
    }


}