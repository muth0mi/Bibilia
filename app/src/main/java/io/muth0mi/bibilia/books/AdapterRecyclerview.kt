package com.ryanada.bibilia.books

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.ryanada.bibilia.R
import com.ryanada.bibilia.databinding.RowBookBinding
import com.ryanada.bibilia.objects.Book
import com.ryanada.bibilia.verses.ActivityVerses

public class AdapterRecyclerview(val activityBooks: ActivityBooks) : RecyclerView.Adapter<AdapterRecyclerview.BookRow>() {

    private var books: List<Book> = ArrayList()

    fun setBooks(books: ArrayList<Book>) {
        this.books = books
        // Sort
//        this.books = books.sortedWith(compareBy { it.id })

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookRow {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_book, parent, false)
        return BookRow(itemView)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookRow, position: Int) {
        val book = books[position]

        // Bind recyclerView row
        holder.bind(book)
    }


    inner class BookRow(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: RowBookBinding = DataBindingUtil.bind(view)!!

        @TargetApi(Build.VERSION_CODES.M)
        fun bind(book: Book) {
            binding.book = book

            binding.root.setOnClickListener {
                val intent = Intent(activityBooks, ActivityVerses::class.java)
                intent.putExtra("book", Gson().toJson(book))
                activityBooks.startActivity(intent)
            }
        }
    }
}
