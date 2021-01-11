package io.github.muth0mi.bibilia.ui.books

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.muth0mi.bibilia.data.objects.Book
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class BooksViewModel : ViewModel() {
    private val testaments = MutableStateFlow(listOf("Agano La Kale", "Agano Jipya"))
    private val selectedTestament = MutableStateFlow(testaments.value[0])

    private val oldTestamentBooks = listOf(Book(1, "1"), Book(2, "2"), Book(3, "3"))
    private val newTestamentBooks = listOf(Book(4, "4"), Book(5, "5"))

    private val _books = MutableStateFlow(emptyList<Book>())
    private val books: StateFlow<List<Book>>
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
}

data class BooksViewState(
    val testaments: List<String> = emptyList(),
    val selectedTestament: String = "",
    val books: List<Book> = emptyList()
)