package com.ryanada.bibiliatakatifu.verses

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.ryanada.bibiliatakatifu.R
import com.ryanada.bibiliatakatifu.databinding.ActivityMain2Binding
import com.ryanada.bibiliatakatifu.objects.Book
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
        binding.title = book.name
        binding.subtitle = book.nameLong

        // Populate recyclerView with bible verses
        val verseAdapter = Adapter(this)
        binding.rvVerses.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvVerses.adapter = verseAdapter
        populateListView(verseAdapter)


    }

    private fun populateListView(verseAdapter: Adapter) {

        val verses = ArrayList<Verse>()
        for (i in 0 until 10) {
            var verse = Verse()
            verse.id = "MAT.1.23" + i
            verse.text = "Behold a virgin shall be with child, and bring forth a son, and they shall call his name Emmanuel, which being interpreted is, God with us. "
            verse.number = "23"

            verses.add(verse)
        }

        verseAdapter.setVerses(verses)
    }

}
