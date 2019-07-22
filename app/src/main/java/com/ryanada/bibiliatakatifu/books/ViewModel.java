package com.ryanada.bibiliatakatifu.books;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.ryanada.bibiliatakatifu.DB.RoomDao;
import com.ryanada.bibiliatakatifu.DB.RoomDb;
import com.ryanada.bibiliatakatifu.objects.Book;

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

    public LiveData<List<Book>> getAllBooks() {
        return roomDao.getAllBooks();
    }

    public void saveBook(Book post) {
        executorService.execute(() -> roomDao.insertBook(post));
    }

    public void saveAllBooks(ArrayList<Book> books) {
        for (Book book : books) {
            executorService.execute(() -> roomDao.insertBook(book));
        }
    }

    public void deleteAllBooks() {
        executorService.execute(() -> roomDao.deleteAllBooks());
    }

}
