package io.github.muth0mi.bibilia.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.muth0mi.bibilia.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val oldTestamentBooks = listOf("1", "2")
    val newTestamentBooks = listOf("3", "4")
    val onClickBook: (String) -> Unit = { book ->
        Log.e("-", "Clicked $book")
    }

    Column() {
        BooksTopAppBar(title = stringResource(R.string.books))
        BooksList(books = oldTestamentBooks, onClickBook = onClickBook)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        App()
    }
}