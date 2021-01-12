package io.github.muth0mi.bibilia.data.repository

import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getTestaments(): ArrayList<Testament>
    suspend fun getBooks(testament: Testament): Flow<List<Book>>
}