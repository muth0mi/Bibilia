package com.ryanada.bibiliatakatifu.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ryanada.bibiliatakatifu.R
import com.ryanada.bibiliatakatifu.databinding.ActivityMainBinding
import com.ryanada.bibiliatakatifu.db.SqliteTransactions
import com.ryanada.bibiliatakatifu.objects.Book


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Set Page Title
        binding.title = "Books"

        // Populate recyclerView with bible books
        val booksAdapter = Adapter(this)
        binding.rvBooks.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvBooks.adapter = booksAdapter

        // Populate recyclerView
        populateListView(booksAdapter, SqliteTransactions(this).getBooks())

    }


    private fun populateListView(booksAdapter: Adapter, books: List<Book>) {
        booksAdapter.setBooks(books as ArrayList<Book>)
    }
}
