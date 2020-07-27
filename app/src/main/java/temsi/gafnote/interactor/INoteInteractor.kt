package temsi.gafnote.interactor

import io.reactivex.Completable
import io.reactivex.Observable
import temsi.gafnote.domain.entities.Note

interface INoteInteractor {

    fun insert(note: Note)

    fun update(note: Note)

    fun delete(note: Note)

    fun deleteAllQuotes()

    fun getAllQuotes(): Observable<List<Note>>
}