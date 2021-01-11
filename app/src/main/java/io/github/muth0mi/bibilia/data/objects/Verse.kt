package io.github.muth0mi.bibilia.data.objects

import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Immutable
@Entity(tableName = "verses")
data class Verse(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String
)