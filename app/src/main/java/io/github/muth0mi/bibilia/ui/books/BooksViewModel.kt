package io.github.muth0mi.bibilia.ui.books

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class BooksViewModel : ViewModel() {
    private val testaments = MutableStateFlow(listOf("Agano La Kale", "Agano Jipya"))
    private val selectedTestament = MutableStateFlow(testaments.value[0])

    private val oldTestamentBooks = listOf("1", "2")
    private val newTestamentBooks = listOf("3", "4")

    private val _books = MutableStateFlow(emptyList<String>())
    private val books: StateFlow<List<String>>
        get() = _books

    private val _state = MutableStateFlow(BooksViewState())
    val state: StateFlow<BooksViewState>
        get() = _state

    init {
        viewModelScope.launch {
            combine(testaments, selectedTestament, books) { testaments, selectedTestament, books ->
                BooksViewState(
                    testaments = testaments,
                    selectedTestament = selectedTestament,
                    books = books
                )
            }.catch { throwable ->
                throw throwable
            }.collect {
                _state.value = it
            }
        }
        _books.value = oldTestamentBooks
    }

    fun onTestamentSelected(testament: String) {
        Log.e("-", testament)
        selectedTestament.value = testament
        _books.value =
            if (books.value == oldTestamentBooks) newTestamentBooks else oldTestamentBooks
    }

    fun onBookClicked(book: String) {
        Log.e("-", book)
    }
}

data class BooksViewState(
    val testaments: List<String> = emptyList(),
    val selectedTestament: String = "",
    val books: List<String> = emptyList()
)