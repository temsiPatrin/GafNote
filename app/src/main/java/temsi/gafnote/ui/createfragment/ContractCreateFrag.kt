package temsi.gafnote.ui.createfragment

import temsi.gafnote.domain.entities.Note
import temsi.gafnote.presenters.base.MvpPresenter
import temsi.gafnote.presenters.base.MvpView

interface ContractCreateFrag {
    interface View : MvpView {
    }

    interface Presenter : MvpPresenter<View> {
        fun insert(note: Note)

    }
}