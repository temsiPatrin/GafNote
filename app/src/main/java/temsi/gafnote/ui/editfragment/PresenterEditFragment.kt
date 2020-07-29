package temsi.gafnote.ui.editfragment

import temsi.gafnote.domain.entities.Note
import temsi.gafnote.interactor.INoteInteractor
import temsi.gafnote.presenters.MVPContract
import temsi.gafnote.presenters.base.BasePresenter

class PresenterEditFragment(private val iNoteInteractor: INoteInteractor) :
    ContractEditFrag.Presenter,
    BasePresenter<ContractEditFrag.View>() {


    override fun update(note: Note) {
        iNoteInteractor.update(note)
    }

    override fun delete(note: Note) {
        iNoteInteractor.delete(note)
    }

    override fun prepareNote(note: Note) {
        view?.showNote(note.title,note.content)
    }

}