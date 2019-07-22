package com.ryanada.bibiliatakatifu.DB;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.ryanada.bibiliatakatifu.objects.Book;
import com.ryanada.bibiliatakatifu.objects.Chapter;
import com.ryanada.bibiliatakatifu.objects.Verse;
import com.ryanada.bibiliatakatifu.objects.VerseContent;


@androidx.room.Database(entities = {Book.class, Chapter.class, Verse.class, VerseContent.class}, version = 2)
//@TypeConverters({Converters.class})

public abstract class RoomDb extends RoomDatabase {

    public abstract RoomDao databaseInterface();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

}