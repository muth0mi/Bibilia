package com.ryanada.bibiliatakatifu.db

import android.app.Activity
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import com.ryanada.bibiliatakatifu.objects.Book
import com.ryanada.bibiliatakatifu.objects.Chapter
import com.ryanada.bibiliatakatifu.objects.Testament
import com.ryanada.bibiliatakatifu.objects.Verse
import java.io.IOException


class SQliteTransactions(private val activity: Activity) {

    // Table name
    private val TABLE_BIBLE = "BIBLE_TABLE"

    // Table Columns names
    private val KEY_ID = "ID"
    private val KEY_BOOKS = "BOOKS"
    private val KEY_CHAPTERS = "CHAPTERS"
    private val KEY_V_NO = "V_NO"
    private val KEY_VERSES = "VERSES"
    private val KEY_NOTES = "NOTES"
    private val KEY_GENERATION = "GENERATION"
    private val KEY_B_STATE = "B_STATE"
    private val KEY_COLORCODE = "COLORCODE"


    // Get database instance from DatabaseHelper class
    private fun getDatabase(): SQLiteDatabase {
        //To hold db
        val db: SQLiteDatabase
        val myDbHelper = DatabaseHelper(activity)

        // Import db if its first launch
        try {
            myDbHelper.createDataBase()
        } catch (ioe: IOException) {
            throw Error("Unable to create database")
        }

        // Initialize db instance
        try {
            db = myDbHelper.openDataBase()
        } catch (sqle: SQLException) {
            throw sqle
        }

        return db
    }


    // Get books from db
    fun getBooks(testament: Testament): ArrayList<Book> {
        // ArrayList to hold books
        val books = ArrayList<Book>()

        // Select All Query
        val query = "SELECT $KEY_BOOKS, $KEY_GENERATION, $KEY_ID FROM $TABLE_BIBLE WHERE $KEY_GENERATION = '" + testament.testament + "'"

        val db = getDatabase()
        val cursor = db.rawQuery(query, null)

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            val temp = ArrayList<String>()
            do {
                // Insert book to arrayList while ignoring duplicates
                if (!temp.contains(cursor.getString(0))) {
                    temp.add(cursor.getString(0))

                    val book = Book()
                    book.book = cursor.getString(0)
                    book.testament = cursor.getString(1)
                    book.id = cursor.getInt(2)
                    books.add(book)
                }
            } while (cursor.moveToNext())

            // Clear temporary list to optimize memory
            temp.clear()
        }

        // closing connection
        cursor.close()
        db.close()

        return books
    }


    // Get chapters from db
    fun getChapters(book: Book): ArrayList<Chapter> {
        // ArrayList to hold chapters
        val chapters = ArrayList<Chapter>()

        // Select All Query
        val query = "SELECT $KEY_CHAPTERS, $KEY_BOOKS FROM $TABLE_BIBLE WHERE $KEY_BOOKS = '" + book.book + "'"

        val db = getDatabase()
        val cursor = db.rawQuery(query, null)

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            val temp = ArrayList<String>()
            do {
                // Insert book to arrayList while ignoring duplicates
                if (!temp.contains(cursor.getString(0))) {
                    temp.add(cursor.getString(0))

                    val chapter = Chapter()
                    chapter.chapter = cursor.getString(0)
                    chapter.book = cursor.getString(1)

                    chapters.add(chapter)
                }
            } while (cursor.moveToNext())

            // Clear temporary list to optimize memory
            temp.clear()
        }

        // closing connection
        cursor.close()
        db.close()

        return chapters
    }

    // Get verses from db
    fun getVerses(chapter: Chapter): ArrayList<Verse> {
        // ArrayList to hold verses
        val verses = ArrayList<Verse>()

        // Select All Query
        val query = "SELECT $KEY_BOOKS, $KEY_CHAPTERS, $KEY_V_NO, $KEY_VERSES FROM $TABLE_BIBLE WHERE $KEY_BOOKS = '" + chapter.book + "' AND $KEY_CHAPTERS = '" + chapter.chapter + "'"

        val db = getDatabase()
        val cursor = db.rawQuery(query, null)

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                val verse = Verse()
                verse.verseNumber = cursor.getString(2)
                verse.verse = cursor.getString(3)

                verses.add(verse)
            } while (cursor.moveToNext())
        }

        // closing connection
        cursor.close()
        db.close()

        return verses
    }
}