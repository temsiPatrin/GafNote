package temsi.gafnote.domain.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "content") var content: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString().toString(),
        source.readString().toString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(id)
        writeString(title)
        writeString(content)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Note> = object : Parcelable.Creator<Note> {
            override fun createFromParcel(source: Parcel): Note = Note(source)
            override fun newArray(size: Int): Array<Note?> = arrayOfNulls(size)
        }
    }
}