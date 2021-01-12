package io.github.muth0mi.bibilia.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import io.github.muth0mi.bibilia.BibiliaApplication
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext context: Context) = context as BibiliaApplication
}