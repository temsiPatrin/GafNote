package temsi.gafnote.ui.mainfragment

import androidx.lifecycle.LiveData
import temsi.gafnote.domain.entities.Note
import temsi.gafnote.presenters.base.MvpPresenter
import temsi.gafnote.presenters.base.MvpView

interface ContractMainFrag {
    interface Presenter : MvpPresenter<View> {
        fun getAllNotes(): LiveData<List<Note>>
        fun loadNote()
    }
    interface View : MvpView {

    }
}