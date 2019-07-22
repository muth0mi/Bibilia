package com.ryanada.bibiliatakatifu.versesContent;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.ryanada.bibiliatakatifu.DB.RoomDao;
import com.ryanada.bibiliatakatifu.DB.RoomDb;
import com.ryanada.bibiliatakatifu.objects.VerseContent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ViewModel extends AndroidViewModel {

    private RoomDao roomDao;
    private ExecutorService executorService;

    public ViewModel(@NonNull Application application) {
        super(application);

        RoomDb roomDb = Room.databaseBuilder(this.getApplication().getApplicationContext(), RoomDb.class, "bible").build();

        roomDao = roomDb.databaseInterface();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<VerseContent>> getAllVerses() {
        return roomDao.getAllVerseContents();
    }

    public void saveVerseContent(VerseContent verseContent) {
        executorService.execute(() -> roomDao.insertVerseContent(verseContent));
    }

    public void saveAllVersesContents(ArrayList<VerseContent> verseContents) {
        for (VerseContent verseContent : verseContents) {
            executorService.execute(() -> roomDao.insertVerseContent(verseContent));
        }
    }

    public void deleteAllVerseContents() {
        executorService.execute(() -> roomDao.deleteAllVerseContents());
    }

}
