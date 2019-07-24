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
import com.ryanada.bibiliatakatifu.databinding.ActivityVersesBinding
import com.ryanada.bibiliatakatifu.db.SQliteTransactions
import com.ryanada.bibiliatakatifu.objects.Book
import com.ryanada.bibiliatakatifu.objects.Chapter


class ActivityVerses : AppCompatActivity() {

    private lateinit var binding: ActivityVersesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_verses)

        // Retrieve Book from intent
        val book = Gson().fromJson(intent.getStringExtra("book"), Book::class.java)

        // Toolbar
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Page title
        binding.title = book.book
//        binding.subtitle = book.nameLong

        // Populate recyclerView with bible verses
        val verseAdapter = AdapterRecyclerviewVerses(this)
        binding.rvVerses.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvVerses.adapter = verseAdapter

        // Hide grid on scroll
        binding.rvVerses.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    binding.gridview.visibility = View.GONE
                }

            })


        // Get chapters
        val chapters = SQliteTransactions(this).getChapters(book)
        binding.tvChapter.text = "1"

        // Handle tvChapter click
        binding.tvChapter.setOnClickListener {
            val gridView = binding.gridview
            gridView.visibility = View.VISIBLE


            val chaptersAdapter = AdapterGridviewChapters(this, chapters, binding, verseAdapter)
            gridView.adapter = chaptersAdapter

            // Close search view if open
            binding.svSearch.isIconified = true
            // In case searchView had a query
            binding.svSearch.isIconified = true
        }


        // Btn Next chapter
        binding.btnNext.setOnClickListener {
            val nextIndex = Integer.valueOf(binding.tvChapter.text as String)

            try {
                // Show chapter verses
                val verses = SQliteTransactions(this).getVerses(chapters[nextIndex])
                verseAdapter.setVerses(verses)

                // Update displayed chapter
                binding.tvChapter.text = (nextIndex + 1).toString()
            } catch (_: Exception) {
                Toast.makeText(this, "This is the last chapter of " + book.book, Toast.LENGTH_SHORT).show()
//                Snackbar.make(binding.root, "This is the last chapter of " + chapter.book, Snackbar.LENGTH_SHORT).show()
            }
            binding.gridview.visibility = View.GONE
        }


        // Btn Prev chapter
        binding.btnPrev.setOnClickListener {
            val previousIndex = Integer.valueOf(binding.tvChapter.text as String) - 2

            try {
                // Show chapter verses
                val verses = SQliteTransactions(this).getVerses(chapters[previousIndex])
                verseAdapter.setVerses(verses)

                // Update displayed chapter
                binding.tvChapter.text = (previousIndex + 1).toString()
            } catch (_: Exception) {
                Toast.makeText(this, "This is the first chapter of " + book.book, Toast.LENGTH_SHORT).show()
//                Snackbar.make(binding.root, "This is the first chapter of " + chapter.book, Snackbar.LENGTH_SHORT).show()
            }
            binding.gridview.visibility = View.GONE
        }


        // Search
        binding.svSearch.setOnSearchClickListener {
            binding.gridview.visibility = View.GONE
        }


        // Get Verses in chapter 1
        val chapter = Chapter()
        chapter.chapter = "1"
        chapter.book = book.book
        val verses = SQliteTransactions(this).getVerses(chapter)
        verseAdapter.setVerses(verses)
    }


    override fun onDestroy() {
        super.onDestroy()
        this.finish()
    }

}
