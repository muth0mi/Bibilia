package io.github.muth0mi.bibilia.data.repository

import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import io.github.muth0mi.bibilia.data.room.BooksDao
import io.github.muth0mi.bibilia.util.FileUtility
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf

class BookRepositoryImpl(
    private val booksDao: BooksDao,
    private val fileUtility: FileUtility
) : BookRepository {

    private suspend fun addBooks(books: List<Book>) = booksDao.insert(books)

    override suspend fun getBooks(testament: Testament): Flow<List<Book>> {
        return booksDao.books(testament).also {
            if (it.first().isEmpty()) addBooks(fileUtility.books())
        }
    }


    override fun searchBooks(query: String) = booksDao.books("%${query}%")


    override suspend fun addRecentSearchQuery(query: String) {
        // TODO: 01/13/2021 Store recent Queries In DB
    }

    override fun getRecentSearchQueries(): Flow<List<String>> {
        // TODO: 01/13/2021 Get recent Queries From DB
        return flowOf(listOf("Love", "God", "Peace"))
    }
}