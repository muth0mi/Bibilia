package io.github.muth0mi.bibilia.data.objects

import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Immutable
@Entity(tableName = "books", indices = [Index("name", unique = true)])
data class Book(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "testament") val testament: String = ""
)