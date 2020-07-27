package temsi.gafnote.ui.viewfragment

import temsi.gafnote.domain.entities.Note
import temsi.gafnote.interactor.INoteInteractor
import temsi.gafnote.presenters.base.BasePresenter

class PresenterViewFrag(private val iNoteInteractor: INoteInteractor): BasePresenter<ContractViewFrag.View>(), ContractViewFrag.Presenter {
    override fun loadNote() {
        TODO("Not yet implemented")
    }

}