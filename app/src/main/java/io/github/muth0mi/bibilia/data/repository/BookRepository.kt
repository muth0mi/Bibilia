package io.github.muth0mi.bibilia.data.repository

import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun getBooks(testament: Testament): Flow<List<Book>>

    fun searchBooks(query: String): Flow<List<Book>>

    fun getRecentSearchQueries(): Flow<List<String>>
    suspend fun addRecentSearchQuery(query: String)
}