package com.ryanada.bibiliatakatifu.DB;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker.Observer;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ryanada.bibiliatakatifu.objects.Book;
import com.ryanada.bibiliatakatifu.objects.Chapter;
import com.ryanada.bibiliatakatifu.objects.Verse;
import com.ryanada.bibiliatakatifu.objects.VerseContent;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class RoomDao_Impl implements RoomDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfBook;

  private final EntityInsertionAdapter __insertionAdapterOfVerse;

  private final EntityInsertionAdapter __insertionAdapterOfChapter;

  private final EntityInsertionAdapter __insertionAdapterOfVerseContent;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllBooks;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllVerses;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllChapters;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllVerseContents;

  public RoomDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBook = new EntityInsertionAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `books`(`id`,`bibleId`,`abbreviation`,`name`,`nameLong`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getBibleId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBibleId());
        }
        if (value.getAbbreviation() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAbbreviation());
        }
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        if (value.getNameLong() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNameLong());
        }
      }
    };
    this.__insertionAdapterOfVerse = new EntityInsertionAdapter<Verse>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `verses`(`id`,`orgId`,`bookId`,`chapterId`,`bibleId`,`reference`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Verse value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getOrgId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOrgId());
        }
        if (value.getBookId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBookId());
        }
        if (value.getChapterId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getChapterId());
        }
        if (value.getBibleId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBibleId());
        }
        if (value.getReference() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReference());
        }
      }
    };
    this.__insertionAdapterOfChapter = new EntityInsertionAdapter<Chapter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `chapters`(`id`,`bibleId`,`bookId`,`number`,`reference`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chapter value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getBibleId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBibleId());
        }
        if (value.getBookId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBookId());
        }
        if (value.getNumber() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNumber());
        }
        if (value.getReference() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getReference());
        }
      }
    };
    this.__insertionAdapterOfVerseContent = new EntityInsertionAdapter<VerseContent>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `verseContents`(`id`,`number`,`text`,`bookId`,`chapterId`,`bibleId`,`reference`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, VerseContent value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getNumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNumber());
        }
        if (value.getText() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getText());
        }
        if (value.getBookId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBookId());
        }
        if (value.getChapterId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getChapterId());
        }
        if (value.getBibleId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getBibleId());
        }
        if (value.getReference() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getReference());
        }
      }
    };
    this.__preparedStmtOfDeleteAllBooks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM books";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllVerses = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM verses";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllChapters = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM chapters";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllVerseContents = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM verseContents";
        return _query;
      }
    };
  }

  @Override
  public void insertBook(Book... books) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfBook.insert(books);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertVerse(Verse... verses) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfVerse.insert(verses);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertChapter(Chapter... chapters) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfChapter.insert(chapters);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertVerseContent(VerseContent... verseContents) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfVerseContent.insert(verseContents);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllBooks() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllBooks.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllBooks.release(_stmt);
    }
  }

  @Override
  public void deleteAllVerses() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllVerses.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllVerses.release(_stmt);
    }
  }

  @Override
  public void deleteAllChapters() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllChapters.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllChapters.release(_stmt);
    }
  }

  @Override
  public void deleteAllVerseContents() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllVerseContents.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllVerseContents.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Book>> getAllBooks() {
    final String _sql = "SELECT * FROM books";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Book>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<Book> compute() {
        if (_observer == null) {
          _observer = new Observer("books") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfBibleId = _cursor.getColumnIndexOrThrow("bibleId");
          final int _cursorIndexOfAbbreviation = _cursor.getColumnIndexOrThrow("abbreviation");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfNameLong = _cursor.getColumnIndexOrThrow("nameLong");
          final List<Book> _result = new ArrayList<Book>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Book _item;
            _item = new Book();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpBibleId;
            _tmpBibleId = _cursor.getString(_cursorIndexOfBibleId);
            _item.setBibleId(_tmpBibleId);
            final String _tmpAbbreviation;
            _tmpAbbreviation = _cursor.getString(_cursorIndexOfAbbreviation);
            _item.setAbbreviation(_tmpAbbreviation);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpNameLong;
            _tmpNameLong = _cursor.getString(_cursorIndexOfNameLong);
            _item.setNameLong(_tmpNameLong);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<List<Verse>> getAllVerses() {
    final String _sql = "SELECT * FROM verses";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Verse>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<Verse> compute() {
        if (_observer == null) {
          _observer = new Observer("verses") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfOrgId = _cursor.getColumnIndexOrThrow("orgId");
          final int _cursorIndexOfBookId = _cursor.getColumnIndexOrThrow("bookId");
          final int _cursorIndexOfChapterId = _cursor.getColumnIndexOrThrow("chapterId");
          final int _cursorIndexOfBibleId = _cursor.getColumnIndexOrThrow("bibleId");
          final int _cursorIndexOfReference = _cursor.getColumnIndexOrThrow("reference");
          final List<Verse> _result = new ArrayList<Verse>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Verse _item;
            _item = new Verse();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpOrgId;
            _tmpOrgId = _cursor.getString(_cursorIndexOfOrgId);
            _item.setOrgId(_tmpOrgId);
            final String _tmpBookId;
            _tmpBookId = _cursor.getString(_cursorIndexOfBookId);
            _item.setBookId(_tmpBookId);
            final String _tmpChapterId;
            _tmpChapterId = _cursor.getString(_cursorIndexOfChapterId);
            _item.setChapterId(_tmpChapterId);
            final String _tmpBibleId;
            _tmpBibleId = _cursor.getString(_cursorIndexOfBibleId);
            _item.setBibleId(_tmpBibleId);
            final String _tmpReference;
            _tmpReference = _cursor.getString(_cursorIndexOfReference);
            _item.setReference(_tmpReference);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<List<Chapter>> getAllChapters() {
    final String _sql = "SELECT * FROM chapters";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Chapter>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<Chapter> compute() {
        if (_observer == null) {
          _observer = new Observer("chapters") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfBibleId = _cursor.getColumnIndexOrThrow("bibleId");
          final int _cursorIndexOfBookId = _cursor.getColumnIndexOrThrow("bookId");
          final int _cursorIndexOfNumber = _cursor.getColumnIndexOrThrow("number");
          final int _cursorIndexOfReference = _cursor.getColumnIndexOrThrow("reference");
          final List<Chapter> _result = new ArrayList<Chapter>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Chapter _item;
            _item = new Chapter();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpBibleId;
            _tmpBibleId = _cursor.getString(_cursorIndexOfBibleId);
            _item.setBibleId(_tmpBibleId);
            final String _tmpBookId;
            _tmpBookId = _cursor.getString(_cursorIndexOfBookId);
            _item.setBookId(_tmpBookId);
            final String _tmpNumber;
            _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
            _item.setNumber(_tmpNumber);
            final String _tmpReference;
            _tmpReference = _cursor.getString(_cursorIndexOfReference);
            _item.setReference(_tmpReference);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<List<VerseContent>> getAllVerseContents() {
    final String _sql = "SELECT * FROM verseContents";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<VerseContent>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<VerseContent> compute() {
        if (_observer == null) {
          _observer = new Observer("verseContents") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfNumber = _cursor.getColumnIndexOrThrow("number");
          final int _cursorIndexOfText = _cursor.getColumnIndexOrThrow("text");
          final int _cursorIndexOfBookId = _cursor.getColumnIndexOrThrow("bookId");
          final int _cursorIndexOfChapterId = _cursor.getColumnIndexOrThrow("chapterId");
          final int _cursorIndexOfBibleId = _cursor.getColumnIndexOrThrow("bibleId");
          final int _cursorIndexOfReference = _cursor.getColumnIndexOrThrow("reference");
          final List<VerseContent> _result = new ArrayList<VerseContent>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final VerseContent _item;
            _item = new VerseContent();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpNumber;
            _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
            _item.setNumber(_tmpNumber);
            final String _tmpText;
            _tmpText = _cursor.getString(_cursorIndexOfText);
            _item.setText(_tmpText);
            final String _tmpBookId;
            _tmpBookId = _cursor.getString(_cursorIndexOfBookId);
            _item.setBookId(_tmpBookId);
            final String _tmpChapterId;
            _tmpChapterId = _cursor.getString(_cursorIndexOfChapterId);
            _item.setChapterId(_tmpChapterId);
            final String _tmpBibleId;
            _tmpBibleId = _cursor.getString(_cursorIndexOfBibleId);
            _item.setBibleId(_tmpBibleId);
            final String _tmpReference;
            _tmpReference = _cursor.getString(_cursorIndexOfReference);
            _item.setReference(_tmpReference);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
