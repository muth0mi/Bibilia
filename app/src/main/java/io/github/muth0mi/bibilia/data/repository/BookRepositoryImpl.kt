package io.github.muth0mi.bibilia.data.repository

import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import io.github.muth0mi.bibilia.data.room.BooksDao
import io.github.muth0mi.bibilia.util.FileUtility
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first

class BookRepositoryImpl(private val booksDao: BooksDao, private val fileUtility: FileUtility) :
    BookRepository {

    override fun getTestaments(): MutableStateFlow<ArrayList<Testament>> {
        return MutableStateFlow(arrayListOf(Testament.Old, Testament.New))
    }

    override suspend fun getBooks(testament: Testament): Flow<List<Book>> {
        val books = booksDao.books(testament)
        if (books.first().isEmpty()) {
            fileUtility.getAssetJsonData(testament).forEach { b -> addBook(b) }
        }
        return books
    }

    private suspend fun addBook(book: Book) {
        booksDao.insert(book)
    }
}