package io.github.muth0mi.bibilia.util

import android.content.Context
import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import org.json.JSONArray
import org.json.JSONObject

class FileUtility(private val context: Context) {

    private fun readBibleFile(): String {
        val inputStream = context.assets.open("swahili.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.use { it.read(buffer) }
        return String(buffer)
    }

    fun books() = arrayListOf<Book>().apply {
        val jsonArray = JSONArray(readBibleFile())
        for (i in 0 until jsonArray.length()) {
            val jsonObject = (jsonArray.get(i) as JSONObject)
            val id = jsonObject.getInt("ID")
            val generation = jsonObject.getString("GENERATION")
            val testament = if (generation == "OLD") Testament.New else Testament.Old
            val bookName = jsonObject.getString("BOOKS")
//                val chapter = jsonObject.getString("CHAPTERS")
//                val verseContent = jsonObject.getString("VERSES")
//                val verseNumber = jsonObject.getString("V_NO")
            if (isEmpty() || bookName != last().name) {
                add(Book(id = id, testament = testament, name = bookName))
            }
        }
    }
}