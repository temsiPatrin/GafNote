package temsi.gafnote.ui.createfragment

import temsi.gafnote.domain.entities.Note
import temsi.gafnote.interactor.INoteInteractor
import temsi.gafnote.presenters.base.BasePresenter

class PresenterCreateFragment(private val iNoteInteractor: INoteInteractor) :
    ContractCreateFrag.Presenter,
    BasePresenter<ContractCreateFrag.View>() {
    override fun insert(note: Note) {
        iNoteInteractor.insert(note)
    }


}