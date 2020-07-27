package temsi.gafnote.repo.noterepo

import io.reactivex.Observable
import temsi.gafnote.domain.entities.Note

interface INoteRepo {
    fun insert(note: Note)

    fun update(note: Note)

    fun delete(note: Note)

    fun deleteAllQuotes()

    fun getAllQuotes(): Observable<List<Note>>
}