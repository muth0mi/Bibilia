package com.ryanada.bibiliatakatifu.chapters;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.ryanada.bibiliatakatifu.DB.RoomDao;
import com.ryanada.bibiliatakatifu.DB.RoomDb;
import com.ryanada.bibiliatakatifu.objects.Chapter;

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

    public LiveData<List<Chapter>> getAllChapters() {
        return roomDao.getAllChapters();
    }

    public void saveChapter(Chapter chapter) {
        executorService.execute(() -> roomDao.insertChapter(chapter));
    }

    public void saveAllChapters(ArrayList<Chapter> chapters) {
        for (Chapter chapter : chapters) {
            executorService.execute(() -> roomDao.insertChapter(chapter));
        }
    }

    public void deleteAllChapters() {
        executorService.execute(() -> roomDao.deleteAllChapters());
    }

}
