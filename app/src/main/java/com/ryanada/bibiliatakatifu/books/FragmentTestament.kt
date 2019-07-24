package com.ryanada.bibiliatakatifu.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
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

class FragmentTestament : Fragment() {

    private lateinit var binding: FragmentTestamentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Bind layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_testament, container, false)

        // Initialize parent activityBooks
        val activity = activity as ActivityBooks

        // Populate recyclerView with bible books
        val booksAdapter = AdapterRecyclerview(activity)
        binding.rvBooks.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvBooks.adapter = booksAdapter

        // Populate recyclerView
        val testament = Testament()
        testament.testament = arguments?.getString("testament")
        val books = SQliteTransactions(activity).getBooks(testament)
        booksAdapter.setBooks(books)

        // Search
        activity.binding.include.svSearch.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {

                override fun onQueryTextChange(newText: String): Boolean {
                    // Search query
                    val results = ArrayList<Book>()
                    for (book in books) {
                        if (book.book!!.toLowerCase().contains(newText.toLowerCase())) {
                            results.add(book)
                        }
                        booksAdapter.setBooks(results)

                        Toast.makeText(activity, newText, Toast.LENGTH_SHORT).show()


//                        if (results.isEmpty()) binding.tvNoResults.visibility = View.VISIBLE
//                        else binding.tvNoResults.visibility = View.GONE
                    }

                    return false
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    // task HERE
                    return false
                }

            })

        return binding.root
    }

    companion object {
        // Returns a new instance of this fragment for the given position
        @JvmStatic
        fun newInstance(index: Int): FragmentTestament {
            return FragmentTestament().apply {
                arguments = Bundle().apply {
                    if (index == 0)
                        putString("testament", "OLD")
                    else
                        putString("testament", "NEW")
                }
            }
        }
    }
}