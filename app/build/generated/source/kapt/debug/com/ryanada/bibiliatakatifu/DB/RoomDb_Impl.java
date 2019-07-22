package com.ryanada.bibiliatakatifu.DB;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class RoomDb_Impl extends RoomDb {
  private volatile RoomDao _roomDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `books` (`id` TEXT NOT NULL, `bibleId` TEXT NOT NULL, `abbreviation` TEXT NOT NULL, `name` TEXT NOT NULL, `nameLong` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `chapters` (`id` TEXT NOT NULL, `bibleId` TEXT NOT NULL, `bookId` TEXT NOT NULL, `number` TEXT NOT NULL, `reference` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `verses` (`id` TEXT NOT NULL, `orgId` TEXT NOT NULL, `bookId` TEXT NOT NULL, `chapterId` TEXT NOT NULL, `bibleId` TEXT NOT NULL, `reference` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `verseContents` (`id` TEXT NOT NULL, `number` TEXT NOT NULL, `text` TEXT NOT NULL, `bookId` TEXT NOT NULL, `chapterId` TEXT NOT NULL, `bibleId` TEXT NOT NULL, `reference` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"a1b97dc249e605f7260c0a97f083deb5\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `books`");
        _db.execSQL("DROP TABLE IF EXISTS `chapters`");
        _db.execSQL("DROP TABLE IF EXISTS `verses`");
        _db.execSQL("DROP TABLE IF EXISTS `verseContents`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBooks = new HashMap<String, TableInfo.Column>(5);
        _columnsBooks.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsBooks.put("bibleId", new TableInfo.Column("bibleId", "TEXT", true, 0));
        _columnsBooks.put("abbreviation", new TableInfo.Column("abbreviation", "TEXT", true, 0));
        _columnsBooks.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsBooks.put("nameLong", new TableInfo.Column("nameLong", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBooks = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBooks = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBooks = new TableInfo("books", _columnsBooks, _foreignKeysBooks, _indicesBooks);
        final TableInfo _existingBooks = TableInfo.read(_db, "books");
        if (! _infoBooks.equals(_existingBooks)) {
          throw new IllegalStateException("Migration didn't properly handle books(com.ryanada.bibiliatakatifu.objects.Book).\n"
                  + " Expected:\n" + _infoBooks + "\n"
                  + " Found:\n" + _existingBooks);
        }
        final HashMap<String, TableInfo.Column> _columnsChapters = new HashMap<String, TableInfo.Column>(5);
        _columnsChapters.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsChapters.put("bibleId", new TableInfo.Column("bibleId", "TEXT", true, 0));
        _columnsChapters.put("bookId", new TableInfo.Column("bookId", "TEXT", true, 0));
        _columnsChapters.put("number", new TableInfo.Column("number", "TEXT", true, 0));
        _columnsChapters.put("reference", new TableInfo.Column("reference", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChapters = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChapters = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChapters = new TableInfo("chapters", _columnsChapters, _foreignKeysChapters, _indicesChapters);
        final TableInfo _existingChapters = TableInfo.read(_db, "chapters");
        if (! _infoChapters.equals(_existingChapters)) {
          throw new IllegalStateException("Migration didn't properly handle chapters(com.ryanada.bibiliatakatifu.objects.Chapter).\n"
                  + " Expected:\n" + _infoChapters + "\n"
                  + " Found:\n" + _existingChapters);
        }
        final HashMap<String, TableInfo.Column> _columnsVerses = new HashMap<String, TableInfo.Column>(6);
        _columnsVerses.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsVerses.put("orgId", new TableInfo.Column("orgId", "TEXT", true, 0));
        _columnsVerses.put("bookId", new TableInfo.Column("bookId", "TEXT", true, 0));
        _columnsVerses.put("chapterId", new TableInfo.Column("chapterId", "TEXT", true, 0));
        _columnsVerses.put("bibleId", new TableInfo.Column("bibleId", "TEXT", true, 0));
        _columnsVerses.put("reference", new TableInfo.Column("reference", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVerses = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVerses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVerses = new TableInfo("verses", _columnsVerses, _foreignKeysVerses, _indicesVerses);
        final TableInfo _existingVerses = TableInfo.read(_db, "verses");
        if (! _infoVerses.equals(_existingVerses)) {
          throw new IllegalStateException("Migration didn't properly handle verses(com.ryanada.bibiliatakatifu.objects.Verse).\n"
                  + " Expected:\n" + _infoVerses + "\n"
                  + " Found:\n" + _existingVerses);
        }
        final HashMap<String, TableInfo.Column> _columnsVerseContents = new HashMap<String, TableInfo.Column>(7);
        _columnsVerseContents.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsVerseContents.put("number", new TableInfo.Column("number", "TEXT", true, 0));
        _columnsVerseContents.put("text", new TableInfo.Column("text", "TEXT", true, 0));
        _columnsVerseContents.put("bookId", new TableInfo.Column("bookId", "TEXT", true, 0));
        _columnsVerseContents.put("chapterId", new TableInfo.Column("chapterId", "TEXT", true, 0));
        _columnsVerseContents.put("bibleId", new TableInfo.Column("bibleId", "TEXT", true, 0));
        _columnsVerseContents.put("reference", new TableInfo.Column("reference", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVerseContents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVerseContents = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVerseContents = new TableInfo("verseContents", _columnsVerseContents, _foreignKeysVerseContents, _indicesVerseContents);
        final TableInfo _existingVerseContents = TableInfo.read(_db, "verseContents");
        if (! _infoVerseContents.equals(_existingVerseContents)) {
          throw new IllegalStateException("Migration didn't properly handle verseContents(com.ryanada.bibiliatakatifu.objects.VerseContent).\n"
                  + " Expected:\n" + _infoVerseContents + "\n"
                  + " Found:\n" + _existingVerseContents);
        }
      }
    }, "a1b97dc249e605f7260c0a97f083deb5", "c6aabba8b626f55b808c6770bb31fd35");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "books","chapters","verses","verseContents");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `books`");
      _db.execSQL("DELETE FROM `chapters`");
      _db.execSQL("DELETE FROM `verses`");
      _db.execSQL("DELETE FROM `verseContents`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public RoomDao databaseInterface() {
    if (_roomDao != null) {
      return _roomDao;
    } else {
      synchronized(this) {
        if(_roomDao == null) {
          _roomDao = new RoomDao_Impl(this);
        }
        return _roomDao;
      }
    }
  }
}
