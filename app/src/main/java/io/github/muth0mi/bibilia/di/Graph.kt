package io.github.muth0mi.bibilia.di

import android.content.Context
import androidx.room.Room
import io.github.muth0mi.bibilia.data.room.BibiliaDatabase
import io.github.muth0mi.bibilia.data.room.BooksDao
import io.github.muth0mi.bibilia.data.stores.BookStore
import io.github.muth0mi.bibilia.util.FileUtility
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object Graph {

    lateinit var appContext: Context
        private set
    lateinit var database: BibiliaDatabase
        private set

    private val booksDao: BooksDao
        get() = database.bookDao()

    val bookStore by lazy {
        BookStore(booksDao = database.bookDao(), FileUtility(appContext))
    }

    private val mainDispatcher: CoroutineDispatcher
        get() = Dispatchers.Main

    private val ioDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO

    fun provide(context: Context) {
        appContext = context
        database = Room
            .databaseBuilder(context, BibiliaDatabase::class.java, "bibilia.db")
            .build()
    }
}