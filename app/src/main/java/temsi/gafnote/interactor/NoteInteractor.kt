package temsi.gafnote.interactor

import io.reactivex.Completable
import io.reactivex.Observable
import temsi.gafnote.domain.entities.Note
import temsi.gafnote.repo.noterepo.INoteRepo

class NoteInteractor(private val iNoteRepo: INoteRepo):INoteInteractor {



    override fun insert(note: Note) {
        iNoteRepo.insert(note)
    }

    override fun update(note: Note) {
        iNoteRepo.update(note)
    }

    override fun delete(note: Note) {
        iNoteRepo.delete(note)
    }

    override fun deleteAllQuotes() {
        iNoteRepo.deleteAllQuotes()
    }

    override fun getAllQuotes(): Observable<List<Note>> {
        return iNoteRepo.getAllQuotes()
    }
}