package io.github.muth0mi.bibilia.data.repository

import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import io.github.muth0mi.bibilia.data.room.BooksDao
import io.github.muth0mi.bibilia.util.FileUtility
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class BookRepositoryImpl(
    private val booksDao: BooksDao,
    private val fileUtility: FileUtility
) : BookRepository {

    override fun getTestaments() = arrayListOf(Testament.Old, Testament.New)


    private suspend fun addBooks(books: List<Book>) = booksDao.insert(books)

    override suspend fun getBooks(testament: Testament): Flow<List<Book>> {
        return booksDao.books(testament).also {
            if (it.first().isEmpty()) addBooks(fileUtility.books())
        }
    }
}