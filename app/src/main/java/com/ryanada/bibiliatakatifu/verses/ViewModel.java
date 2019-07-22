package com.ryanada.bibiliatakatifu.verses;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.ryanada.bibiliatakatifu.DB.RoomDao;
import com.ryanada.bibiliatakatifu.DB.RoomDb;
import com.ryanada.bibiliatakatifu.objects.Book;
import com.ryanada.bibiliatakatifu.objects.Verse;

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

    public LiveData<List<Verse>> getAllVerses() {
        return roomDao.getAllVerses();
    }

    public void saveVerse(Verse verse) {
        executorService.execute(() -> roomDao.insertVerse(verse));
    }

    public void saveAllVerses(ArrayList<Verse> verses) {
        for (Verse verse : verses) {
            executorService.execute(() -> roomDao.insertVerse(verse));
        }
    }

    public void deleteAllVerse() {
        executorService.execute(() -> roomDao.deleteAllVerses());
    }

}
