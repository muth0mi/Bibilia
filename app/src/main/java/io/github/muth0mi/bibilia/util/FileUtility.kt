package io.github.muth0mi.bibilia.util

import android.content.Context
import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book
import org.json.JSONArray
import org.json.JSONObject

class FileUtility(private val context: Context) {
    fun getAssetJsonData(testament: Testament): List<Book> {
        val books = arrayListOf<Book>()

        runCatching {
            val inputStream = context.assets.open("swahili.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.use { it.read(buffer) }
            val jsonString = String(buffer)
            val jsonArray = JSONArray(jsonString)
            for (i in 0..jsonArray.length()) {
                val jsonObject = (jsonArray.get(i) as JSONObject)
                val id = jsonObject.getInt("ID")
                val bookName = jsonObject.getString("BOOKS")
                val chapter = jsonObject.getString("CHAPTERS")
                val generation = jsonObject.getString("GENERATION")
                val verseContent = jsonObject.getString("VERSES")
                val verseNumber = jsonObject.getString("V_NO")

                if (books.isEmpty() || bookName != books.last().name) {
                    books.add(
                        Book(
                            name = bookName,
                            testament = if (generation == "OLD") Testament.New else Testament.Old
                        )
                    )
                }
            }
        }

        return books.filter { it.testament == testament }
    }
}