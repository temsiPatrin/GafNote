package temsi.gafnote.di

import androidx.room.Room
import org.koin.androidx.fragment.dsl.fragment

import org.koin.dsl.module

import temsi.gafnote.interactor.INoteInteractor
import temsi.gafnote.interactor.NoteInteractor
import temsi.gafnote.ui.editfragment.PresenterEditFragment
import temsi.gafnote.ui.mainfragment.PresenterMainFragment
import temsi.gafnote.repo.database.NoteDatabase
import temsi.gafnote.repo.noterepo.INoteRepo
import temsi.gafnote.repo.noterepo.NoteRepo
import temsi.gafnote.ui.createfragment.ContractCreateFrag
import temsi.gafnote.ui.createfragment.CreateFragment
import temsi.gafnote.ui.createfragment.PresenterCreateFragment
import temsi.gafnote.ui.editfragment.ContractEditFrag
import temsi.gafnote.ui.mainfragment.MainFragment
import temsi.gafnote.ui.editfragment.EditFragment
import temsi.gafnote.ui.mainfragment.ContractMainFrag
import temsi.gafnote.ui.viewfragment.ContractViewFrag
import temsi.gafnote.ui.viewfragment.PresenterViewFrag
import temsi.gafnote.ui.viewfragment.ViewFragment

val appModule = module {
    factory <ContractMainFrag.Presenter>{
        PresenterMainFragment(
            get()
        )
    }

    factory <ContractCreateFrag.Presenter>{
        PresenterCreateFragment(
            get()
        )
    }

    factory <ContractEditFrag.Presenter>{
        PresenterEditFragment(
            get()
        )
    }

    factory <ContractViewFrag.Presenter>{
        PresenterViewFrag(
            get()
        )
    }

    single {
        Room.databaseBuilder(
            get(),
            NoteDatabase::class.java,
            "notes_database"
        ).build()
    }

    single { get<NoteDatabase>().noteDao() }

    single<INoteRepo> { NoteRepo(get()) }

    single<INoteInteractor> { NoteInteractor(get()) }

    fragment { MainFragment() }
    fragment { EditFragment() }
    fragment { ViewFragment() }
    fragment { CreateFragment() }

}


