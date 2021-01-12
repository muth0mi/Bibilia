package io.github.muth0mi.bibilia.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import io.github.muth0mi.bibilia.ui.bookList.BooksViewModel
import io.github.muth0mi.bibilia.ui.theme.BibiliaTheme
import io.github.muth0mi.bibilia.util.LocaleManager
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val booksViewModel by viewModels<BooksViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocaleManager.updateResources(baseContext, Locale("sw").language)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BibiliaTheme {
                ProvideWindowInsets {
                    BibiliaApp(booksViewModel)
                }
            }
        }
    }
}