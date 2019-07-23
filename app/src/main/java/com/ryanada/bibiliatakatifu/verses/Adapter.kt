package com.ryanada.bibiliatakatifu.verses

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
import com.ryanada.bibiliatakatifu.databinding.RowVerseBinding
import com.ryanada.bibiliatakatifu.objects.Verse

public class Adapter(val activity: Main2Activity) : RecyclerView.Adapter<Adapter.VerseRow>() {

    private var verses = ArrayList<Verse>()

    fun setVerses(verses: ArrayList<Verse>) {
        this.verses = verses
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseRow {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_verse, parent, false)
        return VerseRow(itemView)
    }

    override fun getItemCount(): Int {
        return verses.size
    }

    override fun onBindViewHolder(holder: VerseRow, position: Int) {
        val verse = verses[position]

        // Bind recyclerView row
        holder.bind(verse)
    }


    inner class VerseRow(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: RowVerseBinding = DataBindingUtil.bind(view)!!

        @TargetApi(Build.VERSION_CODES.M)
        fun bind(verse: Verse) {
            binding.verse = verse

            binding.root.setOnClickListener {
                val intent = Intent(activity, Main2Activity::class.java)
                intent.putExtra("book", Gson().toJson(verse))
//                activity.startActivity(intent)
            }
        }
    }
}
