package io.github.muth0mi.bibilia.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import io.github.muth0mi.bibilia.data.room.BibiliaDatabase
import io.github.muth0mi.bibilia.data.room.BooksDao
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideBibiliaDatabase(@ApplicationContext context: Context) = Room
        .databaseBuilder(context, BibiliaDatabase::class.java, "bibilia.db")
        .build()

    @Provides
    fun provideBooksDao(database: BibiliaDatabase): BooksDao {
        return database.bookDao()
    }
}