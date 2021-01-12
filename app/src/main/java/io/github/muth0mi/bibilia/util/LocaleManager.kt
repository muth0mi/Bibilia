package io.github.muth0mi.bibilia.util

import android.content.Context
import android.content.res.Configuration
import java.util.*

object LocaleManager {
    fun updateResources(application: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration = Configuration()
        configuration.locale = locale
        application.resources.updateConfiguration(
            configuration,
            application.resources.displayMetrics
        )
    }
}