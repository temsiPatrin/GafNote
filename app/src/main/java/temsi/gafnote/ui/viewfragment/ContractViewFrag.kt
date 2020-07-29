package temsi.gafnote.ui.viewfragment

import temsi.gafnote.domain.entities.Note
import temsi.gafnote.presenters.base.MvpPresenter
import temsi.gafnote.presenters.base.MvpView

interface ContractViewFrag {
    interface Presenter : MvpPresenter<View>{
        fun delete(note: Note)
        fun prepareNote(note: Note)
    }
    interface View : MvpView{
        fun showNote(title: String, content: String)
    }
}