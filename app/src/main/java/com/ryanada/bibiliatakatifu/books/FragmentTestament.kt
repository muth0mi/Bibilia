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
import com.ryanada.bibiliatakatifu.db.SqliteTransactions
import com.ryanada.bibiliatakatifu.objects.Testament

class TestamentFragment : Fragment() {

    private lateinit var binding: FragmentTestamentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Bind layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_testament, container, false)

        // Initialize parent activity
        val activity = activity as Main3Activity

        // Populate recyclerView with bible books
        val booksAdapter = RecyclerviewAdapter(activity)
        binding.rvBooks.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvBooks.adapter = booksAdapter

        // Populate recyclerView
        val testament = Testament()
        testament.testament = arguments?.getString("testament")
        val books = SqliteTransactions(activity).getBooks(testament)
        booksAdapter.setBooks(books)

        return binding.root
    }

    companion object {
        // Returns a new instance of this fragment for the given position
        @JvmStatic
        fun newInstance(index: Int): TestamentFragment {
            return TestamentFragment().apply {
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