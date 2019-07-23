package com.ryanada.bibiliatakatifu.verses

import android.os.Bundle
import android.view.View
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

        // show chapters
        binding.tvChapter.text = "1"
        binding.tvChapter.setOnClickListener {
            val gridView = binding.gridview
            gridView.visibility = View.VISIBLE

            val chaptersAdapter = ChaptersAdapter(this, chapters, binding, verseAdapter)
            gridView.adapter = chaptersAdapter

        }


        // Btn Next chapter
        binding.btnNext.setOnClickListener {
            val nextIndex = Integer.valueOf(binding.tvChapter.text as String)

            try {
                // Show chapter verses
                val verses = SqliteTransactions(this).getVerses(chapters[nextIndex])
                verseAdapter.setVerses(verses)

                // Update displayed chapter
                binding.tvChapter.text = (nextIndex + 1).toString()
            } catch (_: Exception) {
                Toast.makeText(this, "This is the last chapter of " + book.book, Toast.LENGTH_SHORT).show()
//                Snackbar.make(binding.root, "This is the last chapter of " + chapter.book, Snackbar.LENGTH_SHORT).show()
            }
        }


        // Btn Prev chapter
        binding.btnPrev.setOnClickListener {
            val previousIndex = Integer.valueOf(binding.tvChapter.text as String) - 2

            try {
                // Show chapter verses
                val verses = SqliteTransactions(this).getVerses(chapters[previousIndex])
                verseAdapter.setVerses(verses)

                // Update displayed chapter
                binding.tvChapter.text = (previousIndex + 1).toString()
            } catch (_: Exception) {
                Toast.makeText(this, "This is the first chapter of " + book.book, Toast.LENGTH_SHORT).show()
//                Snackbar.make(binding.root, "This is the first chapter of " + chapter.book, Snackbar.LENGTH_SHORT).show()
            }
        }


        // Get Verses in chapter 1
        val chapter = Chapter()
        chapter.chapter = "1"
        chapter.book = book.book
        val verses = SqliteTransactions(this).getVerses(chapter)
        verseAdapter.setVerses(verses)
    }


    override fun onDestroy() {
        super.onDestroy()
        this.finish()
    }

}
