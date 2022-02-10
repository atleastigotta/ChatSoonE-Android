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

  private volatile OtherUserDao _otherUserDao;

  private volatile ChatListDao _chatListDao;

  private volatile FolderDao _folderDao;

  private volatile FolderContentDao _folderContentDao;

  private volatile IconDao _iconDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ChatTable` (`otherUserIdx` INTEGER NOT NULL, `groupName` TEXT, `message` TEXT, `postTime` INTEGER, `folderIdx` INTEGER NOT NULL, `status` TEXT NOT NULL, `viewType` INTEGER NOT NULL, `isChecked` INTEGER NOT NULL, `isNew` INTEGER, `chatIdx` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `UserTable` (`kakaoUserIdx` INTEGER NOT NULL, `nickname` TEXT, `email` TEXT, `status` TEXT NOT NULL, PRIMARY KEY(`kakaoUserIdx`))");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_UserTable_kakaoUserIdx` ON `UserTable` (`kakaoUserIdx`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `OtherUserTable` (`nickname` TEXT NOT NULL, `image` TEXT, `status` TEXT NOT NULL, `kakaoUserIdx` INTEGER NOT NULL, `otherUserIdx` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `FolderTable` (`idx` INTEGER NOT NULL, `kakaoUserIdx` INTEGER NOT NULL, `parentFolderIdx` INTEGER, `folderName` TEXT NOT NULL, `folderImg` INTEGER NOT NULL, `status` TEXT NOT NULL, PRIMARY KEY(`idx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `FolderContentTable` (`folderIdx` INTEGER NOT NULL, `chatIdx` INTEGER NOT NULL, `status` TEXT, `folderContentIdx` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ChatListTable` (`chatIdx` INTEGER NOT NULL, `nickName` TEXT, `groupName` TEXT NOT NULL, `profileImg` TEXT, `postTime` INTEGER NOT NULL, `message` TEXT, `isNew` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `IconTable` (`iconImage` INTEGER NOT NULL, `idx` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '78306c0659be49477a087cc9057c3a47')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `ChatTable`");
        _db.execSQL("DROP TABLE IF EXISTS `UserTable`");
        _db.execSQL("DROP TABLE IF EXISTS `OtherUserTable`");
        _db.execSQL("DROP TABLE IF EXISTS `FolderTable`");
        _db.execSQL("DROP TABLE IF EXISTS `FolderContentTable`");
        _db.execSQL("DROP TABLE IF EXISTS `ChatListTable`");
        _db.execSQL("DROP TABLE IF EXISTS `IconTable`");
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
        final HashMap<String, TableInfo.Column> _columnsChatTable = new HashMap<String, TableInfo.Column>(10);
        _columnsChatTable.put("otherUserIdx", new TableInfo.Column("otherUserIdx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("groupName", new TableInfo.Column("groupName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("postTime", new TableInfo.Column("postTime", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("folderIdx", new TableInfo.Column("folderIdx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("viewType", new TableInfo.Column("viewType", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("isChecked", new TableInfo.Column("isChecked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("isNew", new TableInfo.Column("isNew", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatTable.put("chatIdx", new TableInfo.Column("chatIdx", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChatTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChatTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChatTable = new TableInfo("ChatTable", _columnsChatTable, _foreignKeysChatTable, _indicesChatTable);
        final TableInfo _existingChatTable = TableInfo.read(_db, "ChatTable");
        if (! _infoChatTable.equals(_existingChatTable)) {
          return new RoomOpenHelper.ValidationResult(false, "ChatTable(com.chat_soon_e.chat_soon_e.data.entities.Chat).\n"
                  + " Expected:\n" + _infoChatTable + "\n"
                  + " Found:\n" + _existingChatTable);
        }
        final HashMap<String, TableInfo.Column> _columnsUserTable = new HashMap<String, TableInfo.Column>(4);
        _columnsUserTable.put("kakaoUserIdx", new TableInfo.Column("kakaoUserIdx", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("nickname", new TableInfo.Column("nickname", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserTable.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserTable = new HashSet<TableInfo.Index>(1);
        _indicesUserTable.add(new TableInfo.Index("index_UserTable_kakaoUserIdx", true, Arrays.asList("kakaoUserIdx")));
        final TableInfo _infoUserTable = new TableInfo("UserTable", _columnsUserTable, _foreignKeysUserTable, _indicesUserTable);
        final TableInfo _existingUserTable = TableInfo.read(_db, "UserTable");
        if (! _infoUserTable.equals(_existingUserTable)) {
          return new RoomOpenHelper.ValidationResult(false, "UserTable(com.chat_soon_e.chat_soon_e.data.entities.User).\n"
                  + " Expected:\n" + _infoUserTable + "\n"
                  + " Found:\n" + _existingUserTable);
        }
        final HashMap<String, TableInfo.Column> _columnsOtherUserTable = new HashMap<String, TableInfo.Column>(5);
        _columnsOtherUserTable.put("nickname", new TableInfo.Column("nickname", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOtherUserTable.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOtherUserTable.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOtherUserTable.put("kakaoUserIdx", new TableInfo.Column("kakaoUserIdx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOtherUserTable.put("otherUserIdx", new TableInfo.Column("otherUserIdx", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOtherUserTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOtherUserTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOtherUserTable = new TableInfo("OtherUserTable", _columnsOtherUserTable, _foreignKeysOtherUserTable, _indicesOtherUserTable);
        final TableInfo _existingOtherUserTable = TableInfo.read(_db, "OtherUserTable");
        if (! _infoOtherUserTable.equals(_existingOtherUserTable)) {
          return new RoomOpenHelper.ValidationResult(false, "OtherUserTable(com.chat_soon_e.chat_soon_e.data.entities.OtherUser).\n"
                  + " Expected:\n" + _infoOtherUserTable + "\n"
                  + " Found:\n" + _existingOtherUserTable);
        }
        final HashMap<String, TableInfo.Column> _columnsFolderTable = new HashMap<String, TableInfo.Column>(6);
        _columnsFolderTable.put("idx", new TableInfo.Column("idx", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFolderTable.put("kakaoUserIdx", new TableInfo.Column("kakaoUserIdx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFolderTable.put("parentFolderIdx", new TableInfo.Column("parentFolderIdx", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFolderTable.put("folderName", new TableInfo.Column("folderName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFolderTable.put("folderImg", new TableInfo.Column("folderImg", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFolderTable.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFolderTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFolderTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFolderTable = new TableInfo("FolderTable", _columnsFolderTable, _foreignKeysFolderTable, _indicesFolderTable);
        final TableInfo _existingFolderTable = TableInfo.read(_db, "FolderTable");
        if (! _infoFolderTable.equals(_existingFolderTable)) {
          return new RoomOpenHelper.ValidationResult(false, "FolderTable(com.chat_soon_e.chat_soon_e.data.entities.Folder).\n"
                  + " Expected:\n" + _infoFolderTable + "\n"
                  + " Found:\n" + _existingFolderTable);
        }
        final HashMap<String, TableInfo.Column> _columnsFolderContentTable = new HashMap<String, TableInfo.Column>(4);
        _columnsFolderContentTable.put("folderIdx", new TableInfo.Column("folderIdx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFolderContentTable.put("chatIdx", new TableInfo.Column("chatIdx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFolderContentTable.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFolderContentTable.put("folderContentIdx", new TableInfo.Column("folderContentIdx", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFolderContentTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFolderContentTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFolderContentTable = new TableInfo("FolderContentTable", _columnsFolderContentTable, _foreignKeysFolderContentTable, _indicesFolderContentTable);
        final TableInfo _existingFolderContentTable = TableInfo.read(_db, "FolderContentTable");
        if (! _infoFolderContentTable.equals(_existingFolderContentTable)) {
          return new RoomOpenHelper.ValidationResult(false, "FolderContentTable(com.chat_soon_e.chat_soon_e.data.entities.FolderContent).\n"
                  + " Expected:\n" + _infoFolderContentTable + "\n"
                  + " Found:\n" + _existingFolderContentTable);
        }
        final HashMap<String, TableInfo.Column> _columnsChatListTable = new HashMap<String, TableInfo.Column>(8);
        _columnsChatListTable.put("chatIdx", new TableInfo.Column("chatIdx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatListTable.put("nickName", new TableInfo.Column("nickName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatListTable.put("groupName", new TableInfo.Column("groupName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatListTable.put("profileImg", new TableInfo.Column("profileImg", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatListTable.put("postTime", new TableInfo.Column("postTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatListTable.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatListTable.put("isNew", new TableInfo.Column("isNew", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatListTable.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChatListTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChatListTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChatListTable = new TableInfo("ChatListTable", _columnsChatListTable, _foreignKeysChatListTable, _indicesChatListTable);
        final TableInfo _existingChatListTable = TableInfo.read(_db, "ChatListTable");
        if (! _infoChatListTable.equals(_existingChatListTable)) {
          return new RoomOpenHelper.ValidationResult(false, "ChatListTable(com.chat_soon_e.chat_soon_e.data.entities.ChatList).\n"
                  + " Expected:\n" + _infoChatListTable + "\n"
                  + " Found:\n" + _existingChatListTable);
        }
        final HashMap<String, TableInfo.Column> _columnsIconTable = new HashMap<String, TableInfo.Column>(2);
        _columnsIconTable.put("iconImage", new TableInfo.Column("iconImage", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIconTable.put("idx", new TableInfo.Column("idx", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIconTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIconTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIconTable = new TableInfo("IconTable", _columnsIconTable, _foreignKeysIconTable, _indicesIconTable);
        final TableInfo _existingIconTable = TableInfo.read(_db, "IconTable");
        if (! _infoIconTable.equals(_existingIconTable)) {
          return new RoomOpenHelper.ValidationResult(false, "IconTable(com.chat_soon_e.chat_soon_e.data.entities.Icon).\n"
                  + " Expected:\n" + _infoIconTable + "\n"
                  + " Found:\n" + _existingIconTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "78306c0659be49477a087cc9057c3a47", "cc10e4cb79f47a6fef14f2371d724ce4");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "ChatTable","UserTable","OtherUserTable","FolderTable","FolderContentTable","ChatListTable","IconTable");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `ChatTable`");
      _db.execSQL("DELETE FROM `UserTable`");
      _db.execSQL("DELETE FROM `OtherUserTable`");
      _db.execSQL("DELETE FROM `FolderTable`");
      _db.execSQL("DELETE FROM `FolderContentTable`");
      _db.execSQL("DELETE FROM `ChatListTable`");
      _db.execSQL("DELETE FROM `IconTable`");
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
    _typeConvertersMap.put(OtherUserDao.class, OtherUserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChatListDao.class, ChatListDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FolderDao.class, FolderDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FolderContentDao.class, FolderContentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(IconDao.class, IconDao_Impl.getRequiredConverters());
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
  public OtherUserDao otherUserDao() {
    if (_otherUserDao != null) {
      return _otherUserDao;
    } else {
      synchronized(this) {
        if(_otherUserDao == null) {
          _otherUserDao = new OtherUserDao_Impl(this);
        }
        return _otherUserDao;
      }
    }
  }

  @Override
  public ChatListDao chatListDao() {
    if (_chatListDao != null) {
      return _chatListDao;
    } else {
      synchronized(this) {
        if(_chatListDao == null) {
          _chatListDao = new ChatListDao_Impl(this);
        }
        return _chatListDao;
      }
    }
  }

  @Override
  public FolderDao folderDao() {
    if (_folderDao != null) {
      return _folderDao;
    } else {
      synchronized(this) {
        if(_folderDao == null) {
          _folderDao = new FolderDao_Impl(this);
        }
        return _folderDao;
      }
    }
  }

  @Override
  public FolderContentDao folderContentDao() {
    if (_folderContentDao != null) {
      return _folderContentDao;
    } else {
      synchronized(this) {
        if(_folderContentDao == null) {
          _folderContentDao = new FolderContentDao_Impl(this);
        }
        return _folderContentDao;
      }
    }
  }

  @Override
  public IconDao iconDao() {
    if (_iconDao != null) {
      return _iconDao;
    } else {
      synchronized(this) {
        if(_iconDao == null) {
          _iconDao = new IconDao_Impl(this);
        }
        return _iconDao;
      }
    }
  }
}
