package io.github.muth0mi.bibilia.data.stores

import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import io.github.muth0mi.bibilia.data.room.BooksDao
import kotlinx.coroutines.flow.Flow

class BookStore(private val booksDao: BooksDao) {

    fun getBooks(testament: Testament): Flow<List<Book>> {
        return booksDao.books(testament)
    }

    suspend fun addBook(book: Book) {
        booksDao.insert(book)
    }
}