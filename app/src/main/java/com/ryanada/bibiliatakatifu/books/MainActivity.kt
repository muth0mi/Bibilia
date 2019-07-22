package com.ryanada.bibiliatakatifu.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ryanada.bibiliatakatifu.R
import com.ryanada.bibiliatakatifu.api.Retriever
import com.ryanada.bibiliatakatifu.databinding.ActivityMainBinding
import com.ryanada.bibiliatakatifu.objects.Book

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Set Page Title
        binding.title = "Books"

        // Populate recyclerView with bible books
        val booksAdapter = Adapter(this)
        binding.rvBooks.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvBooks.adapter = booksAdapter
        populateListView(booksAdapter)

        Retriever(this).getBooks()
//        Retriever(this).volley()
    }

    private fun populateListView(booksAdapter: Adapter) {

        val books = ArrayList<Book>()
        for (i in 0 until 10) {
            var book = Book()
            book.id = "GEN" + i
            book.bibleId = "179568874c45066f-01"
            book.abbreviation = "Gen"
            book.name = "Genesis"
            book.nameLong = "The First Book of Moses, Commonly Called Genesis"

            books.add(book)
        }

        booksAdapter.setBooks(books)
    }
}
