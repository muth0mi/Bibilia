package com.ryanada.bibiliatakatifu.api

import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ryanada.bibiliatakatifu.objects.Book
import org.json.JSONArray


class Retriever(val context: Activity) {
    // Common Parameters
    val apiKey = "0861884250cf70cf44e0364a57b650f9"
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
                    context.runOnUiThread { Toast.makeText(context, "Done $response", Toast.LENGTH_SHORT).show() }

                } catch (_: Exception) {
                }
            },
            { error ->
                Log.e("fetchingBooks", "failed $error")
            }
        ) { // Passing request headers
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["api-key"] = "0861884250cf70cf44e0364a57b650f9"
                return headers
            }

            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
//                params["content-type"] = contentType
                return params
            }
        }

        // Instantiate the RequestQueue.
        Volley.newRequestQueue(context).add(stringRequest)
    }

    fun getBooks_(): ArrayList<Book> {
        AndroidNetworking.initialize(context.applicationContext);

        AndroidNetworking.get("$baseUrl$version/books")
            .addHeaders("api-key", apiKey)
//            .setcon
//            .addQueryParameter("content-type", contentType)
            .setPriority(Priority.HIGH)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {
                    Log.e("fetchingBooks", "Success")

                    val type = object : TypeToken<ArrayList<Book>>() {}.type
                    val books = Gson().fromJson<ArrayList<Book>>(response.toString(), type)

                    context.runOnUiThread {
                        Toast.makeText(context, books[1].name, Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onError(error: ANError) {
                    Log.e("fetchingBooks", "failed " + error.errorBody)

                    // handle error
                }
            })

        return ArrayList()
    }

    fun volley() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(context)
        val url = "http://www.google.com"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                context.runOnUiThread {
                    Toast.makeText(
                        context,
                        "Response is: ${response.substring(0, 500)}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            Response.ErrorListener {
                context.runOnUiThread {
                    Toast.makeText(context, "That didn't work!", Toast.LENGTH_SHORT).show()
                }
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

}
