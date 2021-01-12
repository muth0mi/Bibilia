package io.github.muth0mi.bibilia.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.github.muth0mi.bibilia.data.repository.BookRepository
import io.github.muth0mi.bibilia.data.repository.BookRepositoryImpl
import io.github.muth0mi.bibilia.data.room.BooksDao
import io.github.muth0mi.bibilia.util.FileUtility

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    fun provideBookRepository(fileUtility: FileUtility, booksDao: BooksDao): BookRepository =
        BookRepositoryImpl(booksDao, fileUtility)
}