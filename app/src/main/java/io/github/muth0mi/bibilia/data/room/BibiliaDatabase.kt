package io.github.muth0mi.bibilia.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.muth0mi.bibilia.data.objects.Book
import io.github.muth0mi.bibilia.data.objects.Verse

@Database(
    version = 1,
    exportSchema = false,
    entities = [Book::class, Verse::class]
)
@TypeConverters(EmumConverters::class)
abstract class BibiliaDatabase : RoomDatabase() {
    abstract fun bookDao(): BooksDao
}