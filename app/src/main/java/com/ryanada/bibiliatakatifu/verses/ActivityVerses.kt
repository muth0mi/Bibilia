package com.ryanada.bibiliatakatifu.verses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.ryanada.bibiliatakatifu.R
import com.ryanada.bibiliatakatifu.databinding.ActivityVersesBinding
import com.ryanada.bibiliatakatifu.db.SQliteTransactions
import com.ryanada.bibiliatakatifu.objects.Book
import com.ryanada.bibiliatakatifu.objects.Chapter
import com.ryanada.bibiliatakatifu.objects.Verse


class ActivityVerses : AppCompatActivity() {

    private lateinit var binding: ActivityVersesBinding

    private var verses: ArrayList<Verse> = ArrayList()


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

        // Populate recyclerView with bible verses
        val verseAdapter = AdapterRecyclerviewVerses(this)
        binding.rvVerses.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvVerses.adapter = verseAdapter

        // Hide grid on scroll
        binding.rvVerses.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    binding.gridLayout.visibility = View.GONE
                }

            })


        // Get chapters
        val chapters = SQliteTransactions(this).getChapters(book)
        binding.tvChapter.text = "1"

        // Grid layout
        for (chapter in chapters) {
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val row = inflater.inflate(R.layout.row_chapter, null)
            val tvChapterNumber = row.findViewById<TextView>(R.id.tvChapterNumber)

            tvChapterNumber.text = chapter.chapter
            binding.gridLayout.addView(row)

            // Highlight current chapter
            tvChapterNumber.background = resources.getDrawable(R.drawable.background_chapter_number)
            if (tvChapterNumber.equals(binding.tvChapter.text.toString()))
                tvChapterNumber.background = resources.getDrawable(R.drawable.background_chapter_number_current)

            // Handler for chapter number click
            tvChapterNumber.setOnClickListener { view ->
                //Show verses in selected chapter
                val verses = SQliteTransactions(this).getVerses(chapter)
                verseAdapter.setVerses(verses)

                // Set label and close panel
                binding.tvChapter.text = (view as TextView).text
                binding.gridLayout.visibility = View.GONE
            }
        }

        // Handle tvChapter click
        binding.tvChapter.setOnClickListener {
            val gridLayout = binding.gridLayout
            gridLayout.visibility = View.VISIBLE

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
                this.verses = verses

                // Update displayed chapter
                binding.tvChapter.text = (nextIndex + 1).toString()
            } catch (_: Exception) {
                Toast.makeText(this, "This is the last chapter of " + book.book, Toast.LENGTH_SHORT).show()
            }
            binding.gridLayout.visibility = View.GONE
        }


        // Btn Prev chapter
        binding.btnPrev.setOnClickListener {
            val previousIndex = Integer.valueOf(binding.tvChapter.text as String) - 2

            try {
                // Show chapter verses
                val verses = SQliteTransactions(this).getVerses(chapters[previousIndex])
                verseAdapter.setVerses(verses)
                this.verses = verses

                // Update displayed chapter
                binding.tvChapter.text = (previousIndex + 1).toString()
            } catch (_: Exception) {
                Toast.makeText(this, "This is the first chapter of " + book.book, Toast.LENGTH_SHORT).show()
            }
            binding.gridLayout.visibility = View.GONE
        }


        // Search
        val searchView = binding.svSearch
        searchView.setOnSearchClickListener {
            binding.gridLayout.visibility = View.GONE
        }

        //change search icon color
        val searchIcon = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_button)
        searchIcon.setColorFilter(resources.getColor(R.color.colorSurface))

        //change search icon color
        val searchAutoComplete = searchView.findViewById<AutoCompleteTextView>(androidx.appcompat.R.id.search_src_text)
        searchAutoComplete.setHintTextColor(resources.getColor(R.color.colorSurfaceLight))
        searchAutoComplete.setTextColor(resources.getColor(R.color.colorSurface))

        binding.svSearch.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {


                override fun onQueryTextChange(newText: String): Boolean {
                    // Search query
                    val results = ArrayList<Verse>()
                    for (verse in verses) {
                        if (verse.verse!!.toLowerCase().contains(newText.toLowerCase())) {
                            results.add(verse)
                        }
                        verseAdapter.setVerses(results)

                        if (results.isEmpty()) binding.tvNoResults.visibility = View.VISIBLE
                        else binding.tvNoResults.visibility = View.GONE
                    }

                    return false
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    // task HERE
                    return false
                }

            })


        // Get Verses in chapter 1
        val chapter = Chapter()
        chapter.chapter = "1"
        chapter.book = book.book
        val verses = SQliteTransactions(this).getVerses(chapter)
        verseAdapter.setVerses(verses)
        this.verses = verses

    }


    override fun onDestroy() {
        super.onDestroy()
        this.finish()
    }

}
