package com.ryanada.bibilia.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ryanada.bibilia.R
import com.ryanada.bibilia.databinding.FragmentTestamentBinding
import com.ryanada.bibilia.db.SQliteTransactions
import com.ryanada.bibilia.objects.Testament

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

        return binding.root
    }
}