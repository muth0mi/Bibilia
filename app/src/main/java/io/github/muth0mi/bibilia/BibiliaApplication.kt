package io.github.muth0mi.bibilia

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.github.muth0mi.bibilia.di.Graph

@HiltAndroidApp
class BibiliaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}