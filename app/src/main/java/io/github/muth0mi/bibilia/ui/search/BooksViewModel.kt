package io.github.muth0mi.bibilia.ui.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import io.github.muth0mi.bibilia.data.objects.Verse
import io.github.muth0mi.bibilia.data.repository.BookRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BooksViewModel @ViewModelInject constructor(
    private val bookRepository: BookRepository
) : ViewModel() {

    val selectedTestament = mutableStateOf(Testament.Old)

    fun onTestamentSelected(testament: Testament) = viewModelScope.launch {
        selectedTestament.value = testament
        bookRepository.getBooks(testament).collect { _books.value = it }
    }


    private val _books = mutableStateOf(emptyList<Book>())
    val books: State<List<Book>> get() = _books


    val searching = mutableStateOf(false)

    fun toggleSearching() = viewModelScope.launch {
        searching.value = searching.value.not()
        if (searching.value) bookRepository.getRecentSearchQueries().collect {
            _recentSearchQueries.value = it
        } else {
            searchQuery.value = ""
            searchResults.value = arrayListOf()
        }
    }


    private val _recentSearchQueries = mutableStateOf(emptyList<String>())
    val recentSearchQueries: State<List<String>> get() = _recentSearchQueries

    fun addRecentSearchQuery(searchQuery: String) = viewModelScope.launch {
        bookRepository.searchBooks(searchQuery).collect {
            _books.value = it
        }
    }


    val searchQuery = mutableStateOf("")
    val searchResults = mutableStateOf(arrayListOf<SearchResult>())

    fun onSearchQueryChanged(newSearchQuery: String) {
        searchQuery.value = newSearchQuery
        searchResults.value = arrayListOf()
        newSearchQuery.ifBlank { return }
        viewModelScope.launch {
            bookRepository.searchBooks(newSearchQuery).collect {
                searchResults.value.add(SearchResult.BookResult(it))
            }
        }
    }

    init {
        onTestamentSelected(Testament.Old)
    }
}

sealed class SearchResult {
    data class BookResult(val value: List<Book>) : SearchResult()
    data class VerseResult(val value: List<Verse>) : SearchResult()
}