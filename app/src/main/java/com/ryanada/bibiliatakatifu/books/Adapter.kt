package com.ryanada.bibiliatakatifu.books

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.ryanada.bibiliatakatifu.R
import com.ryanada.bibiliatakatifu.databinding.RowBookBinding
import com.ryanada.bibiliatakatifu.objects.Book
import com.ryanada.bibiliatakatifu.versesContent.Main2Activity

public class Adapter(val activity: MainActivity) : RecyclerView.Adapter<Adapter.BookRow>() {

    private var books = ArrayList<Book>()

    fun setBooks(books: ArrayList<Book>) {
        this.books = books
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
                val intent = Intent(activity, Main2Activity::class.java)
                intent.putExtra("book", Gson().toJson(book))
                activity.startActivity(intent)
            }
        }
    }
}
