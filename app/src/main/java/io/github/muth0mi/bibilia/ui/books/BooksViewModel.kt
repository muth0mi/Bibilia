package io.github.muth0mi.bibilia.ui.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import io.github.muth0mi.bibilia.data.stores.BookStore
import io.github.muth0mi.bibilia.di.Graph
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BooksViewModel(private val bookStore: BookStore = Graph.bookStore) : ViewModel() {
    private val testaments = bookStore.getTestaments()

    private val _selectedTestament = MutableStateFlow(Testament.Old)
    private val selectedTestament: StateFlow<Testament> get() = _selectedTestament

    private val _books = MutableStateFlow(emptyList<Book>())
    private val books: StateFlow<List<Book>>
        get() = _books

    private val _state = MutableStateFlow(BooksViewState(emptyList(), Testament.Old, emptyList()))
    val state: StateFlow<BooksViewState> get() = _state

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

        onTestamentSelected(Testament.Old)
    }

    fun onTestamentSelected(testament: Testament) = CoroutineScope(Dispatchers.IO).launch {
        _selectedTestament.value = testament
        _books.value = bookStore.getBooks(testament).first()
    }
}

data class BooksViewState(
    val testaments: List<Testament>,
    val selectedTestament: Testament,
    val books: List<Book>
)