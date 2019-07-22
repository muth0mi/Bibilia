package com.ryanada.bibiliatakatifu.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ryanada.bibiliatakatifu.R
import com.ryanada.bibiliatakatifu.api.Retriever
import com.ryanada.bibiliatakatifu.databinding.ActivityMainBinding
import com.ryanada.bibiliatakatifu.objects.Book
import com.ryanada.bibiliatakatifu.objects.Chapter
import com.ryanada.bibiliatakatifu.objects.Verse

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel: ViewModel = ViewModelProviders.of(this).get(ViewModel::class.java)


        // Set Page Title
        binding.title = "Books"

        // Populate recyclerView with bible books
        val booksAdapter = Adapter(this)
        binding.rvBooks.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvBooks.adapter = booksAdapter

        viewModel.allBooks.observe(this, Observer<List<Book>> { books ->
            // todo: remove comment
            if (books.isEmpty())
                Thread(Runnable {
                    Retriever(this).getBooks()
                }).start()

            /*///////
            val viewModel_: com.ryanada.bibiliatakatifu.verses.ViewModel = ViewModelProviders.of(this).get(com.ryanada.bibiliatakatifu.verses.ViewModel::class.java)
            viewModel_.allVerses.observe(this, Observer<List<Verse>> { verses ->
                //                Thread(Runnable {
                var i = 0
                for (verse in verses) {
                    Retriever(this).getVerseContents("/" + verse.id)
                    i++

//                        if (i > 10) break
                }
//                }).start()
            })
            ////////
            */


            /*///////
            val viewModel__: com.ryanada.bibiliatakatifu.chapters.ViewModel = ViewModelProviders.of(this).get(com.ryanada.bibiliatakatifu.chapters.ViewModel::class.java)
            viewModel__.allChapters.observe(this, Observer<List<Chapter>> { verses ->
                //                Thread(Runnable {
                var i = 0
                for (verse in verses) {
                    Retriever(this).getVerses("/" + verse.id)
                    i++

//                        if (i > 10) break
                }
//                }).start()
            })
            ///////
            */


            populateListView(booksAdapter, books)
        })


    }

    private fun populateListView(booksAdapter: Adapter, books: List<Book>) {
        booksAdapter.setBooks(books as ArrayList<Book>)
    }
}
