package temsi.gafnote.repo.noterepo

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import temsi.gafnote.domain.entities.Note
import temsi.gafnote.repo.daosao.NoteDao

class NoteRepo(private val noteDao: NoteDao) : INoteRepo {
    @SuppressLint("CheckResult")
    override fun insert(note: Note) {
        noteDao.insert(note).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d("RxJava","Insert Success")},
                { Log.d("RxJava","Insert Error")}
            )
    }

    @SuppressLint("CheckResult")
    override fun update(note: Note) {
        noteDao.update(note).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d("RxJava","Update Success")},
                { Log.d("RxJava","Update Error")}
            )
    }

    @SuppressLint("CheckResult")
    override fun delete(note: Note) {
        noteDao.delete(note).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d("RxJava","Delete Success")},
                { Log.d("RxJava","Delete Error")}
            )
    }

    @SuppressLint("CheckResult")
    override fun deleteAllNotes() {
        Completable.fromAction{noteDao.deleteAllNotes()}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {Log.d("RxJava","Delete all Success")},
                {Log.d("RxJava","Delete all Error")}
            )
    }

    override fun getAllNotes(): Observable<List<Note>> = noteDao.getAllNotes()
}