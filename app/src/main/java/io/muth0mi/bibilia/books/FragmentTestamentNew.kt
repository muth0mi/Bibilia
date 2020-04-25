package io.muth0mi.bibilia.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.muth0mi.bibilia.R
import io.muth0mi.bibilia.databinding.FragmentTestamentBinding
import io.muth0mi.bibilia.db.SQliteTransactions
import io.muth0mi.bibilia.objects.Testament

class FragmentTestamentNew : Fragment() {

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
        testament.testament = "NEW"
        val books = SQliteTransactions(activity).getBooks(testament)
        booksAdapter.setBooks(books)

        return binding.root
    }
}