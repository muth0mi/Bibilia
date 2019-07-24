package com.ryanada.bibiliatakatifu.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ryanada.bibiliatakatifu.R
import com.ryanada.bibiliatakatifu.databinding.FragmentTestamentBinding
import com.ryanada.bibiliatakatifu.db.SQliteTransactions
import com.ryanada.bibiliatakatifu.objects.Book
import com.ryanada.bibiliatakatifu.objects.Testament
import kotlinx.android.synthetic.main.activity_books_appbar.view.*

class FragmentTestamentOld : Fragment() {

    private lateinit var binding: FragmentTestamentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Bind layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_testament, container, false)

        // Initialize parent activityBooks
        val activity = activity as ActivityBooks

        // Populate recyclerView with bible BOOKS
        val booksAdapter = AdapterRecyclerview(activity)
        binding.rvBooks.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvBooks.adapter = booksAdapter

        // Populate recyclerView
        val testament = Testament()
        testament.testament = "OLD"
        val books = SQliteTransactions(activity).getBooks(testament)
        booksAdapter.setBooks(books)
        activity.books = books

        // Search
        activity.binding.include.svSearch.setOnQueryTextListener(
            activity.bookSearcher
        )

        return binding.root
    }
}