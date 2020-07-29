package temsi.gafnote.repo.daosao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import temsi.gafnote.domain.entities.Note

@Dao
interface NoteDao {
    @Insert
    fun insert(note: Note): Completable

    @Update
    fun update(note: Note): Completable

    @Delete
    fun delete(note: Note): Completable

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table ORDER BY id desc")
    fun getAllNotes(): Observable<List<Note>>

}