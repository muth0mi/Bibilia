package io.github.muth0mi.bibilia.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import kotlinx.coroutines.flow.Flow

@Dao
abstract class BooksDao {
    @Query("SELECT id, testament, name FROM books WHERE testament = :testament")
    abstract fun books(testament: Testament): Flow<List<Book>>

    @Query("SELECT id, testament, name FROM books WHERE name LIKE :query")
    abstract fun books(query: String): Flow<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(books: List<Book>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(book: Book)
}