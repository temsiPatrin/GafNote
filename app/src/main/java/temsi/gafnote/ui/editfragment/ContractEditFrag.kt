package temsi.gafnote.ui.editfragment

import temsi.gafnote.domain.entities.Note
import temsi.gafnote.presenters.base.MvpPresenter
import temsi.gafnote.presenters.base.MvpView

interface ContractEditFrag {
    interface View : MvpView{
        fun showNote(title:String,content:String)
    }
    interface Presenter : MvpPresenter<View>{
        fun update(note: Note)
        fun delete(note: Note)
        fun prepareNote(note: Note)
    }
}