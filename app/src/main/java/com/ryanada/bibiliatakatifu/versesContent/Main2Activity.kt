package com.ryanada.bibiliatakatifu.versesContent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.ryanada.bibiliatakatifu.R
import com.ryanada.bibiliatakatifu.databinding.ActivityMain2Binding
import com.ryanada.bibiliatakatifu.objects.Book
import com.ryanada.bibiliatakatifu.objects.VerseContent

class Main2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        // Retrieve Book from intent
        val book = Gson().fromJson(intent.getStringExtra("book"), Book::class.java)
        val viewModel: ViewModel = ViewModelProviders.of(this).get(ViewModel::class.java)

        // Toolbar
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Page title
        binding.title = book.name
        binding.subtitle = book.nameLong

        // Populate recyclerView with bible verses
        val verseAdapter = Adapter(this)
        binding.rvVerses.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvVerses.adapter = verseAdapter
        viewModel.allVerses.observe(this, Observer<List<VerseContent>> { verses ->

            populateListView(verseAdapter, verses)
        })


    }

    private fun populateListView(verseAdapter: Adapter, verses: List<VerseContent>) {
        verseAdapter.setVerses(verses as ArrayList<VerseContent>)
    }

}
