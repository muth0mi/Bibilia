package io.github.muth0mi.bibilia.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.github.muth0mi.bibilia.BibiliaApplication
import io.github.muth0mi.bibilia.util.FileUtility

@InstallIn(ApplicationComponent::class)
@Module
object FileSystemModule {

    @Provides
    fun provideFileUtility(application: BibiliaApplication) =
        FileUtility(application.applicationContext)
}