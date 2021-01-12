package io.github.muth0mi.bibilia.ui.bookList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import io.github.muth0mi.bibilia.data.repository.BookRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BooksViewModel @ViewModelInject constructor(
    private val bookRepository: BookRepository
) : ViewModel() {

    val selectedTestament: MutableState<Testament> = mutableStateOf(Testament.Old)
    val testaments = bookRepository.getTestaments()

    private val _books = mutableStateOf(emptyList<Book>())
    val books: State<List<Book>> get() = _books

    fun onTestamentSelected(testament: Testament) {
        selectedTestament.value = testament
        viewModelScope.launch {
            bookRepository.getBooks(testament).collect { _books.value = it }
        }
    }

    init {
        onTestamentSelected(Testament.Old)
    }
}