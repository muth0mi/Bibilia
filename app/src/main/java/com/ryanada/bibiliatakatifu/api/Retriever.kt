package com.ryanada.bibiliatakatifu.api

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ryanada.bibiliatakatifu.books.MainActivity
import com.ryanada.bibiliatakatifu.objects.Book
import com.ryanada.bibiliatakatifu.objects.Chapter
import com.ryanada.bibiliatakatifu.objects.Verse
import com.ryanada.bibiliatakatifu.objects.VerseContent


class Retriever(val context: MainActivity) {
    // Common Parameters
//    val apiKey = "0861884250cf70cf44e0364a57b650f9"
    val apiKey = "14ffdc4cd88203ca1a99b3fdcfad9c83"
    val contentType = "json"

    // Endpoints
    val baseUrl = "https://api.scripture.api.bible/v1/bibles"
    val version = "/de4e12af7f28f599-01"

    // To retrieve all books from API
    fun getBooks() {
        // Request a string response from the provided URL.
        val stringRequest = object : JsonObjectRequest(Method.GET, "$baseUrl$version/books", null,
            { response ->
                Log.e("fetchingBooks", "success")
                try {
                    // Convert JSON to list
                    val type = object : TypeToken<ArrayList<Book>>() {}.type
                    val books = Gson().fromJson<ArrayList<Book>>(response.getJSONArray("data").toString(), type)

                    // Database instance
                    val viewModel: com.ryanada.bibiliatakatifu.books.ViewModel = ViewModelProviders.of(context).get(com.ryanada.bibiliatakatifu.books.ViewModel::class.java)

                    // Remove Older from db
//                    viewModel.deleteAllBooks()

                    // Save in db
                    viewModel.saveAllBooks(books)

                    // Get and save chapters
                    for (book in books)
                        Thread(Runnable {
                            getChapters("/${book.id}")
                        }).start()

                } catch (e: Exception) {
                    Log.e("fetchingBooks", "failed $e")
                }
            },
            { error ->
                Log.e("fetchingBooks", "failed $error")
            }
        ) { // Passing request headers
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["api-key"] = apiKey
                return headers
            }

            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["content-type"] = contentType
                return params
            }
        }

        // Instantiate the RequestQueue.
        Volley.newRequestQueue(context).add(stringRequest)
    }

    // To retrieve all chapters from API
    fun getChapters(bookId: String) {
        // Request a string response from the provided URL.
        val stringRequest = object : JsonObjectRequest(Method.GET, "$baseUrl$version/books$bookId/chapters", null,
            { response ->
                Log.e("fetchingChapters", "success")
                try {
                    // Convert JSON to list
                    val type = object : TypeToken<ArrayList<Chapter>>() {}.type
                    val chapters = Gson().fromJson<ArrayList<Chapter>>(response.getJSONArray("data").toString(), type)

                    // Database instance
                    val viewModel: com.ryanada.bibiliatakatifu.chapters.ViewModel = ViewModelProviders.of(context).get(com.ryanada.bibiliatakatifu.chapters.ViewModel::class.java)

                    // Remove Older from db
//                    viewModel.deleteAllChapters()

                    // Save in db
                    viewModel.saveAllChapters(chapters)

                    // Get and save verses
                    for (chapter in chapters)
                        Thread(Runnable {
                            getVerses("/${chapter.id}")
                        }).start()


                } catch (e: Exception) {
                    Log.e("fetchingChapters", "failed $e")
                }
            },
            { error ->
                Log.e("fetchingChapters", "failed $error")
            }
        ) { // Passing request headers
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["api-key"] = apiKey
                return headers
            }

            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["content-type"] = contentType
                return params
            }
        }

        // Instantiate the RequestQueue.
        Volley.newRequestQueue(context).add(stringRequest)
    }


    // To retrieve all verses from API
    fun getVerses(chapterId: String) {
        // Request a string response from the provided URL.
        val stringRequest = object : JsonObjectRequest(Method.GET, "$baseUrl$version/chapters$chapterId/verses", null,
            { response ->
                Log.e("fetchingVerses", "success")
                try {
                    // Convert JSON to list
                    val type = object : TypeToken<ArrayList<Verse>>() {}.type
                    val verses = Gson().fromJson<ArrayList<Verse>>(response.getJSONArray("data").toString(), type)

                    //

                    // Database instance
                    val viewModel: com.ryanada.bibiliatakatifu.verses.ViewModel = ViewModelProviders.of(context).get(com.ryanada.bibiliatakatifu.verses.ViewModel::class.java)

                    // Remove Older from db
//                    viewModel.deleteAllBooks()

                    // Save in db
                    viewModel.saveAllVerses(verses)

                    // Get and save verses Contents
                    for (verse in verses)
                        Thread(Runnable {
                            getVerseContents("/${verse.id}")
                        }).start()

                } catch (e: Exception) {
                    Log.e("fetchingVerses", "failed $e")

                }
            },
            { error ->
                Log.e("fetchingVerses", "failed $error")
            }
        ) { // Passing request headers
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["api-key"] = apiKey
                return headers
            }

            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["content-type"] = contentType
                return params
            }
        }

        // Instantiate the RequestQueue.
        Volley.newRequestQueue(context).add(stringRequest)
    }


    // To retrieve all verses from API
    fun getVerseContents(verseId: String) {
        // Request a string response from the provided URL.
        val stringRequest = object : JsonObjectRequest(Method.GET, "$baseUrl$version/verses$verseId?content-type=json", null,
            { response ->
                Log.e("fetchingVersesContents", "success")
                try {
                    // Convert JSON to list
                    val type = object : TypeToken<ArrayList<VerseContent>>() {}.type
                    val jsonVerseContent = response.getJSONObject("data")

                    val verseContent = VerseContent()
                    verseContent.id = jsonVerseContent.getString("id")
                    verseContent.bookId = jsonVerseContent.getString("bookId")
                    verseContent.chapterId = jsonVerseContent.getString("chapterId")
                    verseContent.bibleId = jsonVerseContent.getString("bibleId")
                    verseContent.reference = jsonVerseContent.getString("reference")

                    val content = jsonVerseContent.getJSONArray("content").getJSONObject(0).getJSONArray("items")
                    verseContent.number = content.getJSONObject(0).getJSONObject("attrs").getString("number")
                    verseContent.text = content.getJSONObject(1).getString("text")

                    //

                    // Database instance
                    val viewModel: com.ryanada.bibiliatakatifu.versesContent.ViewModel = ViewModelProviders.of(context).get(com.ryanada.bibiliatakatifu.versesContent.ViewModel::class.java)

                    // Remove Older from db
//                    viewModel.deleteAllBooks()

                    // Save in db
                    viewModel.saveVerseContent(verseContent)

                    Toast.makeText(context, verseContent.text, Toast.LENGTH_SHORT).show()

                } catch (e: Exception) {
                    Log.e("fetchingVersesContents", "failed $e")

                }
            },
            { error ->
                Log.e("fetchingVersesContents", "failed $error")
            }
        ) { // Passing request headers
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["api-key"] = apiKey
                return headers
            }

            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["content-type"] = contentType
                return params
            }
        }

        // Instantiate the RequestQueue.
        Volley.newRequestQueue(context).add(stringRequest)
    }

}
