package io.github.muth0mi.bibilia.data.objects

import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import io.github.muth0mi.bibilia.data.emuns.Testament

@Immutable
@Entity(tableName = "books", indices = [Index("name", unique = true)])
data class Book(
    @ColumnInfo(name = "id") @PrimaryKey val id: Int,
    @ColumnInfo(name = "testament") val testament: Testament,
    @ColumnInfo(name = "name") val name: String
)