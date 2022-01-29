package com.chat_soon_e.chat_soon_e.data.local;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ChatDao _chatDao;

  private volatile UserDao _userDao;

<<<<<<< HEAD
  private volatile FolderDao _folderDao;
=======
  private volatile OtherUserDao _otherUserDao;
>>>>>>> upstream/juyeon

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
<<<<<<< HEAD
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ChatTable` (`name` TEXT, `message` TEXT NOT NULL, `viewType` INTEGER NOT NULL, `isChecked` INTEGER NOT NULL, `idx` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `UserTable` (`id` INTEGER NOT NULL, `nickname` TEXT NOT NULL, `email` TEXT NOT NULL, `status` TEXT NOT NULL, `createdAt` TEXT NOT NULL, `updatedAt` TEXT NOT NULL, `idx` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `FolderTable` (`idx` INTEGER NOT NULL, `name` TEXT NOT NULL, PRIMARY KEY(`idx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6d429a39793aa6fbf811869aa1643011')");
=======
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ChatTable` (`user_idx` INTEGER NOT NULL, `other_user_idx` INTEGER NOT NULL, `groupName` TEXT, `message` TEXT, `postTime` INTEGER, `folderIdx` INTEGER NOT NULL, `status` TEXT NOT NULL, `idx` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `UserTable` (`idx` INTEGER NOT NULL, `nickname` TEXT, `email` TEXT, `status` TEXT NOT NULL, PRIMARY KEY(`idx`))");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_UserTable_idx` ON `UserTable` (`idx`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `OtherUserTable` (`name` TEXT, `image` TEXT, `status` TEXT NOT NULL, `kakao_user_idx` INTEGER NOT NULL, `other_user_idx` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '164de128a622ff90454d6ce5b57433b3')");
>>>>>>> upstream/juyeon
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `ChatTable`");
        _db.execSQL("DROP TABLE IF EXISTS `UserTable`");
<<<<<<< HEAD
        _db.execSQL("DROP TABLE IF EXISTS `FolderTable`");
=======
        _db.execSQL("DROP TABLE IF EXISTS `OtherUserTable`");
>>>>>>> upstream/juyeon
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
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
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
<<<<<<< HEAD
        final HashMap<String, TableInfo.Column> _columnsChatTable = new HashMap<String, TableInfo.Column>(5);
        _columnsChatTable.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("viewType", new TableInfo.Column("viewType", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("isChecked", new TableInfo.Column("isChecked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
=======
        final HashMap<String, TableInfo.Column> _columnsChatTable = new HashMap<String, TableInfo.Column>(8);
        _columnsChatTable.put("user_idx", new TableInfo.Column("user_idx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("other_user_idx", new TableInfo.Column("other_user_idx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("groupName", new TableInfo.Column("groupName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("postTime", new TableInfo.Column("postTime", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("folderIdx", new TableInfo.Column("folderIdx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
>>>>>>> upstream/juyeon
        _columnsChatTable.put("idx", new TableInfo.Column("idx", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChatTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChatTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChatTable = new TableInfo("ChatTable", _columnsChatTable, _foreignKeysChatTable, _indicesChatTable);
        final TableInfo _existingChatTable = TableInfo.read(_db, "ChatTable");
        if (! _infoChatTable.equals(_existingChatTable)) {
          return new RoomOpenHelper.ValidationResult(false, "ChatTable(com.chat_soon_e.chat_soon_e.data.entities.Chat).\n"
                  + " Expected:\n" + _infoChatTable + "\n"
                  + " Found:\n" + _existingChatTable);
        }
<<<<<<< HEAD
        final HashMap<String, TableInfo.Column> _columnsUserTable = new HashMap<String, TableInfo.Column>(7);
        _columnsUserTable.put("id", new TableInfo.Column("id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("nickname", new TableInfo.Column("nickname", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("updatedAt", new TableInfo.Column("updatedAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
=======
        final HashMap<String, TableInfo.Column> _columnsUserTable = new HashMap<String, TableInfo.Column>(4);
>>>>>>> upstream/juyeon
        _columnsUserTable.put("idx", new TableInfo.Column("idx", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("nickname", new TableInfo.Column("nickname", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserTable = new HashSet<TableInfo.Index>(1);
        _indicesUserTable.add(new TableInfo.Index("index_UserTable_idx", true, Arrays.asList("idx")));
        final TableInfo _infoUserTable = new TableInfo("UserTable", _columnsUserTable, _foreignKeysUserTable, _indicesUserTable);
        final TableInfo _existingUserTable = TableInfo.read(_db, "UserTable");
        if (! _infoUserTable.equals(_existingUserTable)) {
          return new RoomOpenHelper.ValidationResult(false, "UserTable(com.chat_soon_e.chat_soon_e.data.entities.User).\n"
                  + " Expected:\n" + _infoUserTable + "\n"
                  + " Found:\n" + _existingUserTable);
        }
<<<<<<< HEAD
        final HashMap<String, TableInfo.Column> _columnsFolderTable = new HashMap<String, TableInfo.Column>(2);
        _columnsFolderTable.put("idx", new TableInfo.Column("idx", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFolderTable.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFolderTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFolderTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFolderTable = new TableInfo("FolderTable", _columnsFolderTable, _foreignKeysFolderTable, _indicesFolderTable);
        final TableInfo _existingFolderTable = TableInfo.read(_db, "FolderTable");
        if (! _infoFolderTable.equals(_existingFolderTable)) {
          return new RoomOpenHelper.ValidationResult(false, "FolderTable(com.chat_soon_e.chat_soon_e.data.entities.Folder).\n"
                  + " Expected:\n" + _infoFolderTable + "\n"
                  + " Found:\n" + _existingFolderTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "6d429a39793aa6fbf811869aa1643011", "82d266141cead559e2bd3f61da0957fd");
=======
        final HashMap<String, TableInfo.Column> _columnsOtherUserTable = new HashMap<String, TableInfo.Column>(5);
        _columnsOtherUserTable.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOtherUserTable.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOtherUserTable.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOtherUserTable.put("kakao_user_idx", new TableInfo.Column("kakao_user_idx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOtherUserTable.put("other_user_idx", new TableInfo.Column("other_user_idx", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOtherUserTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOtherUserTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOtherUserTable = new TableInfo("OtherUserTable", _columnsOtherUserTable, _foreignKeysOtherUserTable, _indicesOtherUserTable);
        final TableInfo _existingOtherUserTable = TableInfo.read(_db, "OtherUserTable");
        if (! _infoOtherUserTable.equals(_existingOtherUserTable)) {
          return new RoomOpenHelper.ValidationResult(false, "OtherUserTable(com.chat_soon_e.chat_soon_e.data.entities.OtherUser).\n"
                  + " Expected:\n" + _infoOtherUserTable + "\n"
                  + " Found:\n" + _existingOtherUserTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "164de128a622ff90454d6ce5b57433b3", "0133888f5b4f4a96afcfb951758771c8");
>>>>>>> upstream/juyeon
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
<<<<<<< HEAD
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "ChatTable","UserTable","FolderTable");
=======
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "ChatTable","UserTable","OtherUserTable");
>>>>>>> upstream/juyeon
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `ChatTable`");
      _db.execSQL("DELETE FROM `UserTable`");
<<<<<<< HEAD
      _db.execSQL("DELETE FROM `FolderTable`");
=======
      _db.execSQL("DELETE FROM `OtherUserTable`");
>>>>>>> upstream/juyeon
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
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ChatDao.class, ChatDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
<<<<<<< HEAD
    _typeConvertersMap.put(FolderDao.class, FolderDao_Impl.getRequiredConverters());
=======
    _typeConvertersMap.put(OtherUserDao.class, OtherUserDao_Impl.getRequiredConverters());
>>>>>>> upstream/juyeon
    return _typeConvertersMap;
  }

  @Override
  public ChatDao chatDao() {
    if (_chatDao != null) {
      return _chatDao;
    } else {
      synchronized(this) {
        if(_chatDao == null) {
          _chatDao = new ChatDao_Impl(this);
        }
        return _chatDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
<<<<<<< HEAD
  public FolderDao folderDao() {
    if (_folderDao != null) {
      return _folderDao;
    } else {
      synchronized(this) {
        if(_folderDao == null) {
          _folderDao = new FolderDao_Impl(this);
        }
        return _folderDao;
=======
  public OtherUserDao otherUserDao() {
    if (_otherUserDao != null) {
      return _otherUserDao;
    } else {
      synchronized(this) {
        if(_otherUserDao == null) {
          _otherUserDao = new OtherUserDao_Impl(this);
        }
        return _otherUserDao;
>>>>>>> upstream/juyeon
      }
    }
  }
}
