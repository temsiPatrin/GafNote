package temsi.gafnote.ui.mainfragment

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import temsi.gafnote.domain.entities.Note
import temsi.gafnote.interactor.INoteInteractor
import temsi.gafnote.presenters.MVPContract
import temsi.gafnote.presenters.base.BasePresenter


class PresenterMainFragment(
    private val noteInteractor: INoteInteractor
) : ContractMainFrag.Presenter,
    BasePresenter<ContractMainFrag.View>() {

    private val allNote: MutableLiveData<List<Note>> = MutableLiveData()

    init {
        loadNote()
    }

    override fun getAllNotes(): LiveData<List<Note>> {
        return allNote
    }

    @SuppressLint("CheckResult")
    override fun loadNote() {
        noteInteractor.getAllQuotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { quotes -> allNote.postValue(quotes) },
                { ererror -> Log.d("RxJava", "Error getting info from interactor into presenter") }
            )
    }




}