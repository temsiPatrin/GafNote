package temsi.gafnote.repo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import temsi.gafnote.domain.entities.Note
import temsi.gafnote.repo.daosao.NoteDao

@Database(entities = [Note::class],version = 1)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun noteDao(): NoteDao
}