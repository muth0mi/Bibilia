package com.ryanada.bibiliatakatifu.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ryanada.bibiliatakatifu.objects.Book;
import com.ryanada.bibiliatakatifu.objects.Chapter;
import com.ryanada.bibiliatakatifu.objects.Verse;
import com.ryanada.bibiliatakatifu.objects.VerseContent;

import java.util.List;

@Dao
public interface RoomDao {
    // Books IO
    @Query("SELECT * FROM books")
    LiveData<List<Book>> getAllBooks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBook(Book... books);

    @Query("DELETE FROM books")
    void deleteAllBooks();


    // Verses IO
    @Query("SELECT * FROM verses")
    LiveData<List<Verse>> getAllVerses();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVerse(Verse... verses);

    @Query("DELETE FROM verses")
    void deleteAllVerses();


    // Chapters IO
    @Query("SELECT * FROM chapters")
    LiveData<List<Chapter>> getAllChapters();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertChapter(Chapter... chapters);

    @Query("DELETE FROM chapters")
    void deleteAllChapters();


    // Verse contents IO
    @Query("SELECT * FROM verseContents")
    LiveData<List<VerseContent>> getAllVerseContents();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVerseContent(VerseContent... verseContents);

    @Query("DELETE FROM verseContents")
    void deleteAllVerseContents();
}


