package temsi.gafnote.ui.viewfragment

import android.util.Log
import temsi.gafnote.domain.entities.Note
import temsi.gafnote.interactor.INoteInteractor
import temsi.gafnote.presenters.base.BasePresenter

class PresenterViewFrag(private val iNoteInteractor: INoteInteractor) :
    BasePresenter<ContractViewFrag.View>(), ContractViewFrag.Presenter {


    override fun delete(note: Note) {
        iNoteInteractor.delete(note)
    }

    override fun prepareNote(note: Note) {
        view?.showNote(note.title, note.content)
    }


}