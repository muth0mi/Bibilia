package com.ryanada.bibiliatakatifu.verses

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.ryanada.bibiliatakatifu.R
import com.ryanada.bibiliatakatifu.databinding.ActivityMain2Binding
import com.ryanada.bibiliatakatifu.db.SqliteTransactions
import com.ryanada.bibiliatakatifu.objects.Book
import com.ryanada.bibiliatakatifu.objects.Chapter
import com.ryanada.bibiliatakatifu.objects.Verse

class Main2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        // Retrieve Book from intent
        val book = Gson().fromJson(intent.getStringExtra("book"), Book::class.java)

        // Toolbar
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Page title
        binding.title = book.book
//        binding.subtitle = book.nameLong

        // Populate recyclerView with bible verses
        val verseAdapter = Adapter(this)
        binding.rvVerses.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvVerses.adapter = verseAdapter

        // Get chapters
        val chapters = SqliteTransactions(this).getChapters(book)


        // Get Verses in chapter 1
        val chapter = Chapter()
        chapter.chapter = "1"
        val verses = SqliteTransactions(this).getVerses(chapter)

        // Populate recyclerview
        populateListView(verseAdapter, verses)


    }

    private fun populateListView(verseAdapter: Adapter, verses: List<Verse>) {
        verseAdapter.setVerses(verses as ArrayList<Verse>)
    }

}
